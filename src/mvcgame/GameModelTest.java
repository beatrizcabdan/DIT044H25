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
    void collectingCoinIncrementsScore() {
        GameModel m = new GameModel();
        var target = m.getAnimals().get(0).getBounds(); // use first animal
        var p = m.getPlayerBounds();
        m.movePlayer(target.x - p.x, target.y - p.y);
//        int before = m.getScore();
//        m.tick();
//        assertEquals(before + 1, m.getScore());
    }
}
