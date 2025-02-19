package Link_Panel;

import AllMom.MomBackground;
import AllMom.MomCharacter;
import Character_component.Mrbean;
import Character_component.Snowkuy;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class GamePanel extends MomBackground {
    private JButton backButton;
    private Image backgroundImage;
    // private Mrbean mrbean = new Mrbean();
    private JLabel money;
    private int sum;

    public GamePanel(CardLayout cardLayout, JPanel mainPanel) {
        super("bggame");
        backgroundImage = new ImageIcon("test.jpeg").getImage();
        backButton = new JButton("Back Game");
        backButton.addActionListener(new CardSwitcher(cardLayout, mainPanel, "MenuPanel"));
        setLayout(null);
        backButton.setLocation(0, 0);
        backButton.setSize(100, 100);
        add(backButton);

        // money = new JLabel(String.valueOf(sum));
        // money.setLocation(1000,0);
        // money.setForeground(Color.WHITE);
        // money.setFont(new Font("Arial", Font.BOLD, 24)); // ใช้ฟอนต์ Arial, ตัวหนา,
        // ขนาด 24
        // money.setSize(100,100);
        // add(money);

        // mrbean.setSize(30, 60);
        // mrbean.setmoveXY(1);
        // add(mrbean);
        this.randomC();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

    public void randomC() {
        ArrayList<MomCharacter> mrbeanList = new ArrayList<>();

        Timer timer = new Timer(5000, _ -> {
            // sum+=1000;
            // money.setText(String.valueOf(sum));
            Random rand = new Random();
            int randomNumber = rand.nextInt(2);
            MomCharacter m;
            if (rand.nextBoolean()) {
                m = new Mrbean(randomNumber);
            } else {
                m = new Snowkuy(randomNumber);
            }

            switch (m) {
                case Mrbean mrbean -> mrbean.setmoveXY(1);
                case Snowkuy snowkuy -> snowkuy.setmoveXY(1);
                default -> {
                }
            }

            this.add(m);
            mrbeanList.add(m);
            repaint();
        });
        timer.start();

        Timer cleaner = new Timer(10, _ -> {
            Iterator<MomCharacter> iterator = mrbeanList.iterator();
            while (iterator.hasNext()) {
                MomCharacter m = iterator.next();
                if (m.getStep() == -1) {
                    this.remove(m);
                    iterator.remove();
                    repaint();
                }
            }
        });
        cleaner.start();
    }

}
