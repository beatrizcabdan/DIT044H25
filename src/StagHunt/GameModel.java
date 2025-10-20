package StagHunt;

// ALL INFO ABOUT THIS GAME: https://en.wikipedia.org/wiki/Stag_hunt

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;

public class GameModel {
    public static final int WORLD_W = 640;
    public static final int WORLD_H = 400;

    private static final int REWARD_HARE = 2;
    private static final int REWARD_STAG = 10;

    // Time window (ms) in which both must tag the same stag to hunt it
    private static final long COOP_WINDOW_MS = 1500;

    private final Player player = new Player(50, 50, 24, 24, 4);
    private final Hunter npcHunter = new Hunter(300, 150, 22, 22);
    private final List<Game> animals = new ArrayList<>();
    private final Random rnd = new Random();

    // Track partial (co-op) tags for stags
    private static final class CoopState {
        boolean playerTagged;
        boolean npcTagged;
        long firstTagMs;
    }
    private final Map<Game, CoopState> coopTags = new HashMap<>();

    private int playerScore = 0;
    private int npcScore = 0;

    public GameModel() {
        animals.add(new Hare(rnd.nextInt(WORLD_W - 20), rnd.nextInt(WORLD_H - 20)));
        animals.add(new Stag(rnd.nextInt(WORLD_W - 30), rnd.nextInt(WORLD_H - 30)));
    }

    public Rectangle getPlayerBounds() { return player.getBounds(); }
    public Rectangle getNpcBounds() { return npcHunter.getBounds(); }
    public int getPlayerScore() { return playerScore; }
    public int getNpcScore() { return npcScore; }
    public boolean isPlayerStealth() { return player.isStealth(); }
    public void togglePlayerStealth() { player.toggleStealth(); }
    public Player getPlayer() { return player; }
    public List<Game> getAnimals() { return animals; }
    public int getSpeed() { return player.getSpeed(); }
    public Class<? extends Game> getHunterTargetType() { return npcHunter.getTargetType(); }

    public void movePlayer(int dx, int dy) {
        player.moveClamped(dx, dy, WORLD_W, WORLD_H);
    }

    public void tick() {
        player.updateStealth();

        // 1) Move animals
        for (Game g : animals) g.move(WORLD_W, WORLD_H);

        // 2) NPC choose and move toward a target (no random walk)
        npcHunter.chooseTarget(animals);
        npcHunter.moveTowardTarget(WORLD_W, WORLD_H);

        // 3) Resolve catches
        Rectangle pBounds = player.getBounds();
        Rectangle npcBounds = npcHunter.getBounds();
        List<Game> spawns = new ArrayList<>();

        long now = System.currentTimeMillis();

        for (Iterator<Game> it = animals.iterator(); it.hasNext();) {
            Game g = it.next();
            Rectangle gb = g.getBounds();

            boolean playerHit = pBounds.intersects(gb);
            boolean npcHit = npcBounds.intersects(gb);

            if (g instanceof Hare) {
                // Solo catch OK
                if (playerHit || npcHit) {
                    it.remove();
                    coopTags.remove(g); // cleanup just in case
                    int reward = REWARD_HARE;
                    if (playerHit) playerScore += reward;
                    if (npcHit) {
                        npcScore += reward;
                        npcHunter.onCatch();
                    }
                    // Respawn hare
                    spawns.add(new Hare(rnd.nextInt(WORLD_W - 20), rnd.nextInt(WORLD_H - 20)));
                }
            } else if (g instanceof Stag) {
                // Needs co-op: both must tag within window
                CoopState cs = coopTags.get(g);

                // Expire old partial tags
                if (cs != null && (now - cs.firstTagMs) > COOP_WINDOW_MS) {
                    coopTags.remove(g);
                    cs = null;
                }

                // Apply new tags this tick
                if (playerHit || npcHit) {
                    if (cs == null) {
                        cs = new CoopState();
                        cs.firstTagMs = now;
                        coopTags.put(g, cs);
                    }
                    if (playerHit) cs.playerTagged = true;
                    if (npcHit)   cs.npcTagged = true;
                }

                // If both tagged within window: success
                if (cs != null && cs.playerTagged && cs.npcTagged) {
                    it.remove();
                    coopTags.remove(g);
                    // Both get full stag reward
                    playerScore += REWARD_STAG;
                    npcScore += REWARD_STAG;
                    npcHunter.onCatch();
                    // Respawn stag
                    spawns.add(new Stag(rnd.nextInt(WORLD_W - 30), rnd.nextInt(WORLD_H - 30)));
                }
            }
        }

        animals.addAll(spawns);
    }

    // For testing or debugging: directly set the NPC's position.
    public void moveNpcTo(int x, int y) {
        // Access the internal hunter's bounds directly
        Rectangle npcRect = npcHunter.getBounds();
        // Update internal rectangle position
        // Because getBounds() returns a copy, we need to do it on the real field
        try {
            var field = Hunter.class.getDeclaredField("bounds");
            field.setAccessible(true);
            Rectangle realBounds = (Rectangle) field.get(npcHunter);
            realBounds.setLocation(x, y);
        } catch (Exception e) {
            throw new RuntimeException("Failed to move NPC for testing", e);
        }
    }
}
