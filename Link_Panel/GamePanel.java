package Link_Panel;

import AllMom.*;
import AllTread.GameThread.*;
import Animal_component.Browny;
import Animal_component.Greenny;
import Animal_component.Reddy;
import Animal_component.StormFly;
import Background_component.*;
import Button_component.Start;
import DataBase.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends MomBackground {
    private DataUser dataUser;
    private DataMap dataMap;
    private HashMap<String, Object> animal_1, animal_2, animal_3, animal_4, animal_5, animal_6, animal_7;

    private JButton backButton;
    private Image backgroundImage;
    private JLabel money;
    private int sum;
    private Cage1 c1;
    private Cage2 c2;
    private Cage3 c3;
    private Cage4 c4;
    private Cage5 c5;
    private Cage6 c6;
    private Cage7 c7;
    private RandomCharacterThread randomCharacterThread;
    private CleanerCharacterThraed cleanerCharacterThread;
    private CheckCharacter checkCharacter;
    private ArrayList<MomCharacter> charactersList = new ArrayList<>();

    private Thread addAnimalThread;

    private Greenny greenny;
    private Browny browny;
    private StormFly stormFly;
    private Reddy reddy;

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
            // t.setVisible(!t.isVisible());
            animal_2.put("Level", 1);
            animal_3.put("Level", 1);
            animal_3.put("Evo",2);
            animal_1.put("Evo", 1);
            animal_4.put("Level",1);
            animal_4.put("Evo",2);
        });

        // add(t);
        add(s);

        // Bank b = new Bank(680, 280, 4);
        // add(b);

        c1 = new Cage1();
        setComponentZOrder(c1, 0);
        add(c1);

        c2 = new Cage2();
        setComponentZOrder(c2, 0);
        add(c2);

        c3 = new Cage3();
        setComponentZOrder(c3, 0);
        add(c3);

        c4 = new Cage4();
        setComponentZOrder(c4, 0);
        add(c4);

        c5 = new Cage5();
        setComponentZOrder(c5, 0);
        add(c5);

        c6 = new Cage6();
        setComponentZOrder(c6, 0);
        add(c6);

        c7 = new Cage7();
        setComponentZOrder(c7, 0);
        add(c7);
    }

    public void start_Game(DataUser dataUser, int index) {
        this.dataUser = dataUser;
        dataMap = dataUser.getDataUser().get(index);
        addAnimalThread = new Thread(() -> {
            try {
                while (true) { 
                    loadAnimal();
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
            }
        });
        addAnimalThread.start();
        randomCharacterThread = new RandomCharacterThread(this, charactersList);
        cleanerCharacterThread = new CleanerCharacterThraed(this, true, charactersList);
        checkCharacter = new CheckCharacter(randomCharacterThread, charactersList);
        checkCharacter.setMax_Character(dataMap.getMax_Character());
        randomCharacterThread.start();
        cleanerCharacterThread.start();
        checkCharacter.start();
    }

    public void stop_Game() {
        new DataBase(dataUser);
        randomCharacterThread.interrupt();
        cleanerCharacterThread.interrupt();
        checkCharacter.interrupt();
        saveAnimal();
        addAnimalThread.interrupt();
        System.out.println("GameStop");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

    @SuppressWarnings("unchecked")
    private void loadAnimal() {
        animal_1 = (HashMap<String, Object>) dataMap.getAnimal().get("Animal_1");
        animal_2 = (HashMap<String, Object>) dataMap.getAnimal().get("Animal_2");
        animal_3 = (HashMap<String, Object>) dataMap.getAnimal().get("Animal_3");
        animal_4 = (HashMap<String, Object>) dataMap.getAnimal().get("Animal_4");
        animal_5 = (HashMap<String, Object>) dataMap.getAnimal().get("Animal_5");
        animal_6 = (HashMap<String, Object>) dataMap.getAnimal().get("Animal_6");
        animal_7 = (HashMap<String, Object>) dataMap.getAnimal().get("Animal_7");

        int evo_1 = (int) animal_1.get("Evo");
        int level_1 = (int) animal_1.get("Level");
        int evo_2 = (int) animal_2.get("Evo");
        int level_2 = (int) animal_2.get("Level");
        int evo_3 = (int) animal_3.get("Evo");
        int level_3 = (int) animal_3.get("Level");
        int evo_4 = (int) animal_4.get("Evo");
        int level_4 = (int) animal_4.get("Level");
        int evo_5 = (int) animal_5.get("Evo");
        int level_5 = (int) animal_5.get("Level");
        int evo_6 = (int) animal_6.get("Evo");
        int level_6 = (int) animal_6.get("Level");
        int evo_7 = (int) animal_7.get("Evo");
        int level_7 = (int) animal_7.get("Level");

        if (level_1 > 0) {
            if(greenny == null){
                greenny = new Greenny();
                add(greenny);
                setComponentZOrder(greenny, 1);
                greenny.setEvo(evo_1);
                greenny.setLevel(level_1);
                greenny.startMove();
            }
            greenny.setEvo(evo_1);
            greenny.setLevel(level_1);
        }

        if (level_2 > 0) {
            if(browny == null){
                browny = new Browny();
                add(browny);
                setComponentZOrder(browny, 1);
                browny.setEvo(evo_2);
                browny.setLevel(level_2);
                browny.startMove();
            }
            browny.setEvo(evo_2);
            browny.setLevel(level_2);
        }

        if (level_3 > 0) {
            if(stormFly == null){
                stormFly = new StormFly();
                add(stormFly);
                setComponentZOrder(stormFly, 1);
                stormFly.setEvo(evo_3);
                stormFly.setLevel(level_3);
                stormFly.startMove();
            }
            stormFly.setEvo(evo_3);
            stormFly.setLevel(level_3);
        }

        if (level_4 > 0) {
            if(reddy == null){
                reddy = new Reddy();
                add(reddy);
                setComponentZOrder(reddy, 1);
                reddy.setEvo(evo_4);
                reddy.setLevel(level_4);
                reddy.startMove();
            }
            reddy.setEvo(evo_4);
            reddy.setLevel(level_4);
        }

        // if(evo_5 >= 0 ){
        // greenny = new Greenny();
        // greenny.startMove();
        // greenny.setEvo(evo_5);
        // greenny.setLevel(level_5);
        // add(greenny);
        // setComponentZOrder(greenny, 1);
        // }

        // if(evo_6 >= 0 ){
        // greenny = new Greenny();
        // greenny.startMove();
        // greenny.setEvo(evo_6);
        // greenny.setLevel(level_6);
        // add(greenny);
        // setComponentZOrder(greenny, 1);
        // }

        // if(evo_7 >= 0 ){
        // greenny = new Greenny();
        // greenny.startMove();
        // greenny.setEvo(evo_7);
        // greenny.setLevel(level_7);
        // add(greenny);
        // setComponentZOrder(greenny, 1);
        // }
    }

    private void saveAnimal() {
        if (greenny != null) {
            greenny.stopMove();
            remove(greenny);
            greenny = null;
        }
        if (browny != null) {
            browny.stopMove();
            remove(browny);
            browny = null;
        }
        if (stormFly != null) {
            stormFly.stopMove();
            remove(stormFly);
            stormFly = null;
        }
        if (reddy != null) {
            reddy.stopMove();
            remove(reddy);
            reddy = null;
        }
    }

}
