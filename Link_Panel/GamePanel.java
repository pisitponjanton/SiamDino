package Link_Panel;

import AllMom.MomBackground;
import AllMom.MomCharacter;
import AllTread.GameThread.CheckCharacter;
import AllTread.GameThread.CleanerCharacterThraed;
import AllTread.GameThread.RandomCharacterThread;
import Animal_component.Greenny;
import Background_component.Cage1;
import Background_component.Cage2;
import Background_component.TestManu;
import Button_component.Start;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class GamePanel extends MomBackground {
    private JButton backButton;
    private Image backgroundImage;
    private JLabel money;
    private int sum;
    private Cage1 c1;
    private Cage2 c2;
    private RandomCharacterThread randomCharacterThread;
    private CleanerCharacterThraed cleanerCharacterThread;
    private CheckCharacter checkCharacter;
    private ArrayList<MomCharacter> charactersList = new ArrayList<>();

    private Greenny gg;

    public GamePanel(CardLayout cardLayout, JPanel mainPanel) {
        super("bggame");
        backgroundImage = new ImageIcon("test.jpeg").getImage();
        backButton = new JButton("Back Game");

        setLayout(null);
        backButton.setLocation(0, 0);
        backButton.setSize(100, 100);

        backButton.addActionListener(_ -> {
            randomCharacterThread.cleanerList();
            this.stop_Game();
            cardLayout.show(mainPanel, "MenuPanel");
        });

        add(backButton);

        TestManu t = new TestManu();
        t.setSize(500, 500);
        t.setLocation(500, 200);
        t.setVisible(false);
        Start s = new Start();
        s.setLocation(1150, 0);
        s.addActionListener(_ -> {
            t.setVisible(!t.isVisible());
        });
        // add(t);
        // add(s);
        gg = new Greenny();
        gg.startMove();
        add(gg);

        // Bank b = new Bank(680, 280, 4);
        // add(b);

        c1 = new Cage1();
        setComponentZOrder(c1, 0);
        add(c1);

        c2 = new Cage2();
        setComponentZOrder(c2, 0);
        add(c2);
    }

    public ArrayList<MomCharacter> getCharactersList() {
        return this.charactersList;
    }

    public void start_Game() {
        randomCharacterThread = new RandomCharacterThread(this, charactersList);
        cleanerCharacterThread = new CleanerCharacterThraed(this,true, charactersList);
        checkCharacter = new CheckCharacter(randomCharacterThread, charactersList);
        randomCharacterThread.start();
        cleanerCharacterThread.start();
        checkCharacter.start();
    }
    
    public void stop_Game() {
        randomCharacterThread.interrupt();
        cleanerCharacterThread.interrupt();
        checkCharacter.interrupt();
        System.out.println("GameStop");
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }


}
