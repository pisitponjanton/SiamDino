package Link_Panel;

import AllMom.Animation;
import AllMom.MomBackground;
import Background_component.NameGame;
import Button_component.*;
import Sound.*;
import java.awt.*;
import javax.swing.*;

public class MenuPanel extends MomBackground {
    private Start startButton;
    private NameGame namegame;
    private int i;
    private ButtonMute1 buttonMute1;

    public MenuPanel(CardLayout cardLayout, JPanel mainPanel) {
        super("bgset/0");

        new Thread(()->{
            try {
                while (true) { 
                    Thread.sleep(300);
                    super.setNamePath("bgset/"+(i%10));
                    i++;
                }
            } catch (InterruptedException e) {
            }
        }).start();

        setLayout(null);

        buttonMute1 = new ButtonMute1();
        buttonMute1.addActionListener(_->{
            if(buttonMute1.getNamePath().equals("mute1")){
                buttonMute1.setNamePath("mute2");
                SoundMusic.setP(false);
                SoundGame.stop();
                SoundInGame.stop();
            }
            else{
                buttonMute1.setNamePath("mute1");
                SoundMusic.setP(true);
                SoundGame.play();
                SoundPop.play();
            }
        });
        add(buttonMute1);

        startButton = new Start();
        startButton.setLocation(600, 400);
        new Animation(startButton, 0);
        startButton.addActionListener(_ ->{
            cardLayout.show(mainPanel, "MapMenuPanel");
            SoundStart.play();
            System.out.println("Start");
        });
        add(startButton);

        namegame = new NameGame();
        add(namegame);
    }
}
