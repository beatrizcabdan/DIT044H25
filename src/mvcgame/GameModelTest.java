package mvcgame;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameModelTest {
    @Test
    void movingIsClampedToWorld() {
        GameModel m = new GameModel();
        // slam left/up
        m.movePlayer(-10_000, -10_000);
        var p1 = m.getPlayerBounds();
        assertEquals(0, p1.x);
        assertEquals(0, p1.y);

        // slam right/down
        m.movePlayer(10_000, 10_000);
        var p2 = m.getPlayerBounds();
        assertEquals(GameModel.WORLD_W - p2.width, p2.x);
        assertEquals(GameModel.WORLD_H - p2.height, p2.y);
    }

    @Test
    void huntingStagGivesMorePointsThanHare() {
        GameModel model = new GameModel();

        // Prepare one hare and one stag
        Hare hare = new Hare(100, 100);
        Stag stag = new Stag(200, 200);
        model.getAnimals().clear();
        model.getAnimals().add(hare);
        model.getAnimals().add(stag);

        // === Player catches hare ===
        var p = model.getPlayerBounds();
        model.movePlayer(hare.getBounds().x - p.x, hare.getBounds().y - p.y);
        model.tick(); // player catches hare

        int afterHareScore = model.getPlayerScore();

        // === Co-op stag hunt ===
        model.getAnimals().clear();
        stag = new Stag(200, 200);
        model.getAnimals().add(stag);

        // Move both player and NPC on the stag position
        model.movePlayer(stag.getBounds().x - model.getPlayerBounds().x,
                stag.getBounds().y - model.getPlayerBounds().y);

        // Force NPC directly over the stag as well
        model.moveNpcTo(stag.getBounds().x, stag.getBounds().y);

        // --- First tick: one of them tags ---
        model.tick();
        // --- Second tick (within coop window): simulate both tagging again ---
        model.tick();

        int afterStagScore = model.getPlayerScore();

        // === Assertions ===
        assertTrue(afterStagScore > afterHareScore,
                "Catching a stag should give more points than catching a hare.");

        assertEquals(2, hare.getReward());
        assertEquals(10, stag.getReward());
        assertTrue(stag.getReward() > hare.getReward(),
                "Stag reward should be higher than hare reward.");
    }

    @Test
    void coopHuntGivesPointsToBothPlayerAndNpc() {
        GameModel model = new GameModel();

        // Single stag
        Stag stag = new Stag(200, 200);
        model.getAnimals().clear();
        model.getAnimals().add(stag);

        // Move both onto stag
        model.movePlayer(stag.getBounds().x - model.getPlayerBounds().x,
                stag.getBounds().y - model.getPlayerBounds().y);
        model.moveNpcTo(stag.getBounds().x, stag.getBounds().y);

        // Run multiple ticks to allow cooperation window
        model.tick();
        model.tick();
        model.tick();

        assertEquals(model.getPlayerScore(), model.getNpcScore(),
                "Both player and NPC should get equal points for a co-op stag hunt.");
        assertTrue(model.getPlayerScore() >= stag.getReward(),
                "Each participant should get at least the stag reward after cooperation.");
    }

    @Test
    void stagCannotBeHuntedSolo() {
        GameModel model = new GameModel();

        // Place a single stag in the world
        Stag stag = new Stag(150, 150);
        model.getAnimals().clear();
        model.getAnimals().add(stag);

        // Move only the player onto the stag position
        var playerStart = model.getPlayerBounds();
        model.movePlayer(stag.getBounds().x - playerStart.x, stag.getBounds().y - playerStart.y);

        // Keep NPC away (no cooperation)
        model.moveNpcTo(0, 0);

        int beforeScore = model.getPlayerScore();
        int beforeNpcScore = model.getNpcScore();

        // Simulate multiple ticks — enough time for any solo tag to expire
        for (int i = 0; i < 5; i++) {
            model.tick();
            try { Thread.sleep(400); } catch (InterruptedException ignored) {} // simulate time passing
        }

        int afterScore = model.getPlayerScore();
        int afterNpcScore = model.getNpcScore();

        // === Assertions ===
        assertEquals(beforeScore, afterScore, "Player should NOT get points when hunting a stag alone.");
        assertEquals(beforeNpcScore, afterNpcScore, "NPC should NOT get points without cooperation.");
        assertTrue(model.getAnimals().stream().anyMatch(a -> a instanceof Stag),
                "Stag should remain alive if only one participant tagged it.");
    }
}
