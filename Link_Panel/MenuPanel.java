package Link_Panel;

import AllMom.MomBackground;
import Background_component.NameGame;
import Button_component.Start;
import java.awt.*;
import javax.swing.*;

public class MenuPanel extends MomBackground {
    private Start startButton;
    private NameGame namegame;

    public MenuPanel(CardLayout cardLayout, JPanel mainPanel) {
        super("bg");

        setLayout(null);

        startButton = new Start();
        startButton.addActionListener(new CardSwitcher(cardLayout, mainPanel, "GamePanel"));
        add(startButton);

        namegame = new NameGame();
        add(namegame);


    }
}
