package StagHunt;

import javax.swing.*;

public class GameApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameModel model = new GameModel();
            GameView view = new GameView(model);
            JFrame window = GameView.createWindow(view);
            GameController controller = new GameController(model, view);
            window.setVisible(true);
            controller.start();
        });
    }
}
