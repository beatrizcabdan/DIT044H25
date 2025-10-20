package mvcgame;

import java.awt.*;
import java.util.List;
import java.util.Random;

public class Hunter {
    private final Rectangle bounds;
    private final Random rnd = new Random();

    private final int speed = 2;
    private double dx = 0, dy = 0;
    private Class<? extends Game> targetType = null;
    private Game currentTarget = null;

    public Hunter(int x, int y, int w, int h) {
        this.bounds = new Rectangle(x, y, w, h);
        chooseTargetType();
    }

    public Rectangle getBounds() { return new Rectangle(bounds); }

    public int getSpeed() { return speed; }

    private void chooseTargetType() {
        targetType = rnd.nextBoolean() ? Hare.class : Stag.class;
    }

    public void chooseTarget(List<Game> animals) {
        Game nearest = null;
        double bestDist = Double.MAX_VALUE;

        for (Game g : animals) {
            if (!targetType.isInstance(g)) continue;
            double dx = g.getBounds().getCenterX() - bounds.getCenterX();
            double dy = g.getBounds().getCenterY() - bounds.getCenterY();
            double dist = Math.hypot(dx, dy);
            if (dist < bestDist) {
                bestDist = dist;
                nearest = g;
            }
        }

        currentTarget = nearest;
        if (currentTarget == null) chooseTargetType();
    }

    public void moveTowardTarget(int worldW, int worldH) {
        if (currentTarget == null) return;
        Rectangle target = currentTarget.getBounds();
        double tx = target.getCenterX() - bounds.getCenterX();
        double ty = target.getCenterY() - bounds.getCenterY();
        double dist = Math.hypot(tx, ty);
        if (dist > 1) {
            dx = tx / dist;
            dy = ty / dist;
        }
        bounds.x += (int) (dx * speed);
        bounds.y += (int) (dy * speed);

        bounds.x = Math.max(0, Math.min(worldW - bounds.width, bounds.x));
        bounds.y = Math.max(0, Math.min(worldH - bounds.height, bounds.y));
    }

    public void onCatch() {
        chooseTargetType();
        currentTarget = null;
    }

    public Class<? extends Game> getTargetType() {
        return targetType;
    }
}
