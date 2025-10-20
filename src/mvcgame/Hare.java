package mvcgame;

import java.awt.*;

public class Hare extends Game {
    public Hare(int x, int y) {
        super(x, y, 10, 10);
    }

    @Override
    public Color getColor() {
        return new Color(255, 255, 255);
    }

    @Override
    public int getSpeed() {
        return 3;
    }

    @Override
    public int getReward() {
        return 2; // Hare reward
    }
}
