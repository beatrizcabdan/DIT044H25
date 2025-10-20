package StagHunt;

// ALL INFO ABOUT THIS GAME: https://en.wikipedia.org/wiki/Stag_hunt

import java.awt.*;
import java.util.Random;

public abstract class Game {
    protected Rectangle bounds;
    protected double dx, dy;
    protected final Random rnd = new Random();

    public Game(int x, int y, int w, int h) {
        this.bounds = new Rectangle(x, y, w, h);
        randomizeDirection();
    }

    public Rectangle getBounds() { return new Rectangle(bounds); }

    public abstract Color getColor();
    public abstract int getSpeed();

    // each animal defines its own reward value
    public abstract int getReward();

    public void move(int worldW, int worldH) {
        if (rnd.nextDouble() < 0.05) randomizeDirection();

        bounds.x += (int) (dx * getSpeed());
        bounds.y += (int) (dy * getSpeed());

        if (bounds.x < 0 || bounds.x > worldW - bounds.width) dx *= -1;
        if (bounds.y < 0 || bounds.y > worldH - bounds.height) dy *= -1;

        bounds.x = Math.max(0, Math.min(worldW - bounds.width, bounds.x));
        bounds.y = Math.max(0, Math.min(worldH - bounds.height, bounds.y));
    }

    private void randomizeDirection() {
        double angle = rnd.nextDouble() * 2 * Math.PI;
        dx = Math.cos(angle);
        dy = Math.sin(angle);
    }
}
