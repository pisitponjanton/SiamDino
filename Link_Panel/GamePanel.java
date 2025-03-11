package Link_Panel;

import AllMom.*;
import AllTread.GameThread.*;
import Animal_component.Browny;
import Animal_component.FlyMeToTheMoon;
import Animal_component.Greenny;
import Animal_component.Reddy;
import Animal_component.StormFly;
import Background_component.*;
import Background_component.Cage.Cage1;
import Background_component.Cage.Cage2;
import Background_component.Cage.Cage3;
import Background_component.Cage.Cage4;
import Background_component.Cage.Cage5;
import Background_component.Cage.Cage6;
import Background_component.Cage.Cage7;
import Background_component.Store.*;
import Button_component.Start;
import DataBase.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends MomBackground {
    private DataUser dataUser;
    private DataMap dataMap;
    private HashMap<String, Object> animal_1, animal_2, animal_3, animal_4, animal_5, animal_6, animal_7;
    private Integer[] cage;
    private HashMap<String, Object> store_1, store_2, store_3;

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
    private FlyMeToTheMoon flyMeToTheMoon;

    private Food food;
    private Water water;
    private Icream icream;

    public GamePanel(CardLayout cardLayout, JPanel mainPanel) {
        super("bggame");

        backgroundImage = new ImageIcon("test.jpeg").getImage();
        backButton = new JButton("Back Game");

        setLayout(null);
        backButton.setLocation(0, 0);
        backButton.setSize(100, 100);
        backButton.setToolTipText("Back");
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
            animal_3.put("Evo", 2);
            animal_1.put("Evo", 2);
            animal_4.put("Level", 1);
            animal_4.put("Evo", 2);
            store_3.put("Level", 1);
            store_1.put("Evo", 2);
            cage[2] = 2;
            animal_5.put("Level", 1);
            animal_5.put("Evo", 1);
        });

        // add(t);
        add(s);
        allCage_Add();

    }

    public void start_Game(DataUser dataUser, int index) {
        this.dataUser = dataUser;
        dataMap = dataUser.getDataUser().get(index);
        addAnimalThread = new Thread(() -> {
            try {
                while (true) {
                    loadAnimal();
                    loadStore();
                    loadCage();
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
        saveStore();
        addAnimalThread.interrupt();
        System.out.println("GameStop");
    }

    private void allCage_Add(){
        c1 = new Cage1();
        setComponentZOrder(c1, 0);
        c1.setVisible(false);
        add(c1);

        c2 = new Cage2();
        setComponentZOrder(c2, 0);
        c2.setVisible(false);
        add(c2);

        c3 = new Cage3();
        setComponentZOrder(c3, 0);
        c3.setVisible(false);
        add(c3);

        c4 = new Cage4();
        setComponentZOrder(c4, 0);
        c4.setVisible(false);
        add(c4);

        c5 = new Cage5();
        setComponentZOrder(c5, 0);
        c5.setVisible(false);
        add(c5);

        c6 = new Cage6();
        setComponentZOrder(c6, 0);
        c6.setVisible(false);
        add(c6);

        c7 = new Cage7();
        setComponentZOrder(c7, 0);
        c7.setVisible(false);
        add(c7);
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
            if (greenny == null) {
                c1.setVisible(true);
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
            if (browny == null) {
                c2.setVisible(true);
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
            if (stormFly == null) {
                c6.setVisible(true);
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
            if (reddy == null) {
                c3.setVisible(true);
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

        if (level_5 > 0) {
            if (flyMeToTheMoon == null) {
                c5.setVisible(true);
                flyMeToTheMoon = new FlyMeToTheMoon();
                add(flyMeToTheMoon);
                setComponentZOrder(flyMeToTheMoon, 1);
                flyMeToTheMoon.setEvo(evo_5);
                flyMeToTheMoon.setLevel(level_5);
                flyMeToTheMoon.startMove();
            }
            flyMeToTheMoon.setEvo(evo_5);
            flyMeToTheMoon.setLevel(level_5);
        }

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

    private void loadCage() {
        cage = dataMap.getAnimal_Cage();
        c1.setLevel(cage[0]);
        c2.setLevel(cage[1]);
        c3.setLevel(cage[2]);
        c4.setLevel(cage[3]);
        c5.setLevel(cage[4]);
        c6.setLevel(cage[5]);
        c7.setLevel(cage[6]);
    }

    private void saveAnimal() {
        if (greenny != null) {
            c1.setVisible(false);
            greenny.stopMove();
            remove(greenny);
            greenny = null;
        }
        if (browny != null) {
            c2.setVisible(false);
            browny.stopMove();
            remove(browny);
            browny = null;
        }
        if (stormFly != null) {
            c6.setVisible(false);
            stormFly.stopMove();
            remove(stormFly);
            stormFly = null;
        }
        if (reddy != null) {
            c3.setVisible(false);
            reddy.stopMove();
            remove(reddy);
            reddy = null;
        }

        if (flyMeToTheMoon != null) {
            c5.setVisible(false);
            flyMeToTheMoon.stopMove();
            remove(flyMeToTheMoon);
            flyMeToTheMoon = null;
        }
    }

    @SuppressWarnings("unchecked")
    private void loadStore() {
        store_1 = (HashMap<String, Object>) dataMap.getStore().get("Store_1");
        store_2 = (HashMap<String, Object>) dataMap.getStore().get("Store_2");
        store_3 = (HashMap<String, Object>) dataMap.getStore().get("Store_3");
        int store_1_Level = (int) store_1.get("Level");
        int store_1_Evo = (int) store_1.get("Evo");
        int store_1_Profit = (int) store_1.get("Profit");
        int store_2_Level = (int) store_2.get("Level");
        int store_2_Evo = (int) store_2.get("Evo");
        int store_2_Profit = (int) store_2.get("Profit");
        int store_3_Level = (int) store_3.get("Level");
        int store_3_Evo = (int) store_3.get("Evo");
        int store_3_Profit = (int) store_3.get("Profit");

        if (store_1_Level > 0) {
            if (food == null) {
                food = new Food();
                add(food);
                setComponentZOrder(food, 0);
                food.setEvo(store_1_Evo);
                food.setLevel(store_1_Level);
                food.setProfit(store_1_Profit);
            }
            food.setEvo(store_1_Evo);
            food.setLevel(store_1_Level);
            food.setProfit(store_1_Profit);
        }

        if (store_2_Level > 0) {
            if (water == null) {
                water = new Water();
                add(water);
                setComponentZOrder(water, 0);
                water.setEvo(store_2_Evo);
                water.setLevel(store_2_Level);
                water.setProfit(store_2_Profit);
            }
            water.setEvo(store_2_Evo);
            water.setLevel(store_2_Level);
            water.setProfit(store_2_Profit);
        }

        if (store_3_Level > 0) {
            if (icream == null) {
                icream = new Icream();
                add(icream);
                setComponentZOrder(icream, 0);
                icream.setEvo(store_3_Evo);
                icream.setLevel(store_3_Level);
                icream.setProfit(store_3_Profit);
            }
            icream.setEvo(store_3_Evo);
            icream.setLevel(store_3_Level);
            icream.setProfit(store_3_Profit);
        }
    }

    private void saveStore(){
        if(food != null){
            remove(food);
            food = null;
        }

        if(water != null){
            remove(water);
            water = null;
        }

        if(icream != null){
            remove(icream);
            icream = null;
        }
    }
}
