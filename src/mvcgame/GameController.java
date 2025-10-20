package mvcgame;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameController {
    private final GameModel model;
    private final GameView view;

    private boolean up, down, left, right;
    private boolean spaceHeld = false;
    private final Timer timer = new Timer(16, e -> onTick());

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;

        view.addKeyListener(new KeyAdapter() {
            @Override public void keyPressed(KeyEvent e) { setKey(e.getKeyCode(), true); }
            @Override public void keyReleased(KeyEvent e) { setKey(e.getKeyCode(), false); }
        });
    }

    public void start() {
        timer.start();
        SwingUtilities.invokeLater(view::requestFocusInWindow);
    }

    private void onTick() {
        int s = model.getSpeed();
        int dx = (right ? s : 0) - (left ? s : 0);
        int dy = (down  ? s : 0) - (up   ? s : 0);

        if (dx != 0 || dy != 0) model.movePlayer(dx, dy);
        model.tick();
        view.repaint();
    }

    private void setKey(int code, boolean pressed) {
        switch (code) {
            case KeyEvent.VK_UP    -> up = pressed;
            case KeyEvent.VK_DOWN  -> down = pressed;
            case KeyEvent.VK_LEFT  -> left = pressed;
            case KeyEvent.VK_RIGHT -> right = pressed;
            case KeyEvent.VK_SPACE -> {
                if (pressed && !spaceHeld) model.togglePlayerStealth();
                spaceHeld = pressed;
            }
            default -> {}
        }
    }
}
