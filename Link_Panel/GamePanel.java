package Link_Panel;

import AllMom.MomBackground;
import AllMom.MomCharacter;
import Animal_component.Greenny;
import Background_component.Cage1;
import Background_component.Cage2;
import Background_component.TestManu;
import Button_component.Start;
import Character_component.Bank;
import Character_component.Mrbean;
import Character_component.Snowkuy;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends MomBackground {
    private JButton backButton;
    private Image backgroundImage;
    private JLabel money;
    private int sum;
    private Cage1 c1;
    private Cage2 c2;

    public GamePanel(CardLayout cardLayout, JPanel mainPanel) {
        super("bggame");
        backgroundImage = new ImageIcon("test.jpeg").getImage();
        backButton = new JButton("Back Game");
        backButton.addActionListener(new CardSwitcher(cardLayout, mainPanel, "MenuPanel"));
        setLayout(null);
        backButton.setLocation(0, 0);
        backButton.setSize(100, 100);
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
        Greenny gg = new Greenny();
        add(gg);

        Bank b = new Bank(0);
        b.setLocation(455, 480);
        b.setmoveXY(4);
        add(b);

        c1 = new Cage1();
        setComponentZOrder(c1, 0);
        add(c1);

        c2 = new Cage2();
        setComponentZOrder(c2, 0);
        add(c2);

        // this.randomCharacter();
        startRandomCharacterThread();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

    // public void randomCharacter() {
    // ArrayList<MomCharacter> mrbeanList = new ArrayList<>();

    // Timer timer = new Timer(10000, _ -> {
    // Random rand = new Random();
    // int random_Character = rand.nextInt(3);
    // MomCharacter m;

    // m = switch (random_Character) {
    // case 0 -> new Mrbean(0);
    // case 1 -> new Snowkuy(0);
    // default -> new Bank(0);
    // };

    // switch (m) {
    // case Mrbean mrbean -> mrbean.setmoveXY(1);
    // case Snowkuy snowkuy -> snowkuy.setmoveXY(1);
    // case Bank bank -> bank.setmoveXY(1);
    // default -> {
    // }
    // }

    // this.add(m);
    // setComponentZOrder(m, 1);
    // mrbeanList.add(m);
    // // System.out.println(mrbeanList.size());
    // repaint();
    // });
    // timer.start();
    // Timer cleaner = new Timer(10, _ -> {
    // Iterator<MomCharacter> iterator = mrbeanList.iterator();
    // while (iterator.hasNext()) {
    // MomCharacter m = iterator.next();
    // if (m.getX() <= 0 || m.getX() >= 1360) {
    // this.remove(m);
    // iterator.remove();
    // repaint();
    // }
    // }
    // });
    // cleaner.start();
    // }

    private void startRandomCharacterThread() {
        ArrayList<MomCharacter> mrbeanList = new ArrayList<>();
        Thread randomCharacterThread = new Thread(() -> {
            Random rand = new Random();
            try {
                while (true) {
                    Thread.sleep(1000);
                    
                    c1.setLevel(c1.getLevel() == 0 ? 1 : c1.getLevel() == 1 ? 2 : 0);
                    c2.setLevel(c2.getLevel() == 0 ? 1 : c2.getLevel() == 1 ? 2 : 0);

                    int random_Character = rand.nextInt(3);
                    MomCharacter m = switch (random_Character) {
                        case 0 -> new Mrbean(0);
                        case 1 -> new Snowkuy(0);
                        default -> new Bank(0);
                    };

                    m.setmoveXY(1);

                    add(m);
                    setComponentZOrder(m, 1);
                    mrbeanList.add(m);
                    repaint();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        randomCharacterThread.start();

        Thread cleanerThread = new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(10);
                    Iterator<MomCharacter> iterator = mrbeanList.iterator();
                    while (iterator.hasNext()) {
                        MomCharacter m = iterator.next();
                        if (m.getX() <= 0 || m.getX() >= 1360) {
                            remove(m);
                            iterator.remove();
                            repaint();
                        }
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        cleanerThread.start();
    }

}
