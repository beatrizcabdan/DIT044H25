package StagHunt;

// ALL INFO ABOUT THIS GAME: https://en.wikipedia.org/wiki/Stag_hunt

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {
    private final GameModel model;

    public GameView(GameModel model) {
        this.model = model;
        setPreferredSize(new Dimension(GameModel.WORLD_W, GameModel.WORLD_H));
        setBackground(new Color(25, 25, 28));
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw animals
        for (Game animal : model.getAnimals()) {
            Rectangle b = animal.getBounds();
            g2.setColor(animal.getColor());
            g2.fillOval(b.x, b.y, b.width, b.height);

            // Optional: give stags a subtle outline to stand out
            if (animal instanceof Stag) {
                g2.setColor(new Color(255, 255, 255, 60));
                g2.setStroke(new BasicStroke(1.2f));
                g2.drawOval(b.x, b.y, b.width, b.height);
            }
        }

        // Draw NPC hunter (color indicates target preference)
        var npc = model.getNpcBounds();
        Color npcColor = new Color(255, 120, 120);
        g2.setColor(npcColor);
        g2.fillRoundRect(npc.x, npc.y, npc.width, npc.height, 6, 6);

        // Draw player (stealth-aware)
        var p = model.getPlayerBounds();
        boolean stealth = model.isPlayerStealth();
        if (stealth) {
            g2.setColor(new Color(90, 200, 250, 110));
            g2.fillRoundRect(p.x, p.y, p.width, p.height, 6, 6);
            g2.setColor(new Color(160, 220, 255, 180));
            g2.setStroke(new BasicStroke(1.5f));
            g2.drawRoundRect(p.x, p.y, p.width, p.height, 6, 6);
        } else {
            g2.setColor(new Color(90, 200, 250));
            g2.fillRoundRect(p.x, p.y, p.width, p.height, 6, 6);
        }

        // HUD
        g2.setColor(Color.WHITE);
        g2.setFont(getFont().deriveFont(Font.BOLD, 14f));
        g2.drawString("Player: " + model.getPlayerScore() + " | NPC: " + model.getNpcScore(), 10, 18);
        String stealthText = stealth
                ? String.format("(Stealth %.1fs left)", model.getPlayer().getRemainingStealthMs() / 1000.0)
                : "(Visible)";
        g2.drawString("Arrows to move | Space: Stealth " + stealthText, 10, 36);
        g2.drawString("Hare = 2 pts (solo) | Stag = 10 pts (co-op)", 10, 54);

        g2.dispose();
    }

    public static JFrame createWindow(GameView view) {
        JFrame frame = new JFrame("MVC Hunting Game");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(view);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        return frame;
    }
}
