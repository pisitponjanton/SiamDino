package Link_Panel;

import AllMom.Animation;
import AllMom.MomBackground;
import Background_component.NameGame;
import Button_component.Start;
import java.awt.*;
import javax.swing.*;

public class MenuPanel extends MomBackground {
    private Start startButton;
    private NameGame namegame;

    public MenuPanel(CardLayout cardLayout, JPanel mainPanel,GamePanel g) {
        super("bg");

        setLayout(null);

        startButton = new Start();
        startButton.setLocation(600, 400);
        new Animation(startButton, 0);
        startButton.addActionListener(new CardSwitcher(cardLayout, mainPanel, "GamePanel"));
        startButton.addActionListener(_ ->{
            g.start_Game();
            System.out.println("GameStart");
        });
        add(startButton);

        namegame = new NameGame();
        add(namegame);
    }
}
