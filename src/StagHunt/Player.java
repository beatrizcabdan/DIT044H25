package StagHunt;

// ALL INFO ABOUT THIS GAME: https://en.wikipedia.org/wiki/Stag_hunt

import java.awt.*;

public class Player {
    private final Rectangle bounds;
    private int speed;
    private boolean stealth = false;
    private long stealthStartTime = 0L;
    private static final long MAX_STEALTH_MS = 5000; // 5 seconds

    public Player(int x, int y, int w, int h, int speed) {
        this.bounds = new Rectangle(x, y, w, h);
        this.speed  = Math.max(1, speed);
    }

    public Rectangle getBounds() { return new Rectangle(bounds); }
    public int getSpeed()        { return speed; }
    public void setSpeed(int s)  { this.speed = Math.max(1, s); }
    public boolean isStealth()   { return stealth; }

    public long getRemainingStealthMs() {
        if (!stealth) return 0;
        long elapsed = System.currentTimeMillis() - stealthStartTime;
        return Math.max(0, MAX_STEALTH_MS - elapsed);
    }

    public void toggleStealth() {
        if (!stealth) {
            stealth = true;
            stealthStartTime = System.currentTimeMillis();
        } else {
            stealth = false;
        }
    }

    public void setStealth(boolean on) {
        if (on && !stealth) stealthStartTime = System.currentTimeMillis();
        stealth = on;
    }

    public void updateStealth() {
        if (stealth) {
            long elapsed = System.currentTimeMillis() - stealthStartTime;
            if (elapsed >= MAX_STEALTH_MS) stealth = false;
        }
    }

    public void moveClamped(int dx, int dy, int worldW, int worldH) {
        int nx = clamp(bounds.x + dx, 0, worldW - bounds.width);
        int ny = clamp(bounds.y + dy, 0, worldH - bounds.height);
        bounds.setLocation(nx, ny);
    }

    private static int clamp(int v, int lo, int hi) {
        return Math.max(lo, Math.min(hi, v));
    }
}
