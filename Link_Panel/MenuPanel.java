package Link_Panel;

import AllMom.MomBackground;
import Background_component.NameGame;
import Button_component.Start;
import Character_component.Mrbean;
import Character_component.Snowkuy;
import java.awt.*;
import javax.swing.*;

public class MenuPanel extends MomBackground {
    private Start startButton;
    private Mrbean mrbean;
    private Snowkuy snowkuy;
    private NameGame namegame;

    public MenuPanel(CardLayout cardLayout, JPanel mainPanel) {
        super("bg");

        setLayout(null);

        startButton = new Start();
        startButton.addActionListener(new CardSwitcher(cardLayout, mainPanel, "GamePanel"));
        add(startButton);

        namegame = new NameGame();
        add(namegame);

        snowkuy = new Snowkuy();
        mrbean = new Mrbean();

        add(snowkuy);
        add(mrbean);
    }
}
