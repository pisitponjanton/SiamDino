import Link_Panel.GamePanel;
import Link_Panel.MapMenuPanel;
import Link_Panel.MenuPanel;
import Sound.SoundGame;
import java.awt.*;
import javax.swing.*;

public class Main {
    private JFrame frame;
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public Main() {
        SoundGame.play();
        
        frame = new JFrame("Siam Dino");
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        GamePanel gamePanel = new GamePanel(cardLayout, mainPanel);
        MenuPanel startMenu = new MenuPanel(cardLayout, mainPanel);
        MapMenuPanel mapMenuPanel = new MapMenuPanel(cardLayout, mainPanel,gamePanel);
        
        mainPanel.add(startMenu, "MenuPanel");
        mainPanel.add(mapMenuPanel, "MapMenuPanel");
        mainPanel.add(gamePanel, "GamePanel");

        frame.add(mainPanel);
        frame.setResizable(false);
        frame.setSize(1350, 800);
        frame.setDefaultCloseOperation(3);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}