package StagHunt;

// ALL INFO ABOUT THIS GAME: https://en.wikipedia.org/wiki/Stag_hunt

import java.awt.*;

public class Stag extends Game {
    public Stag(int x, int y) {
        super(x, y, 30, 30);
    }

    @Override
    public Color getColor() {
        return new Color(150, 75, 0);
    }

    @Override
    public int getSpeed() {
        return 1;
    }

    @Override
    public int getReward() {
        return 10; // Stag reward
    }
}
