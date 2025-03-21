package Link_Panel;

import AllMom.*;
import AllShop.BrownyShop;
import AllShop.DodoShop;
import AllShop.FlyMeToTheMoonShop;
import AllShop.GreenyShop;
import AllShop.IcecreamShop;
import AllShop.RapterShop;
import AllShop.ReddyShop;
import AllShop.RestaurantShop;
import AllShop.StormFlyShop;
import AllShop.WaterShop;
import AllTread.GameThread.*;
import Animal_component.*;
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

    private Thread addAnimalThread, money_Food, money_Water, money_Icream;

    private Greenny greenny;
    private Browny browny;
    private StormFly stormFly;
    private Reddy reddy;
    private FlyMeToTheMoon flyMeToTheMoon;
    private Dodo dodo;
    private Rapter rapter;

    private Food food;
    private Water water;
    private Icream icream;

    private double money;
    private int level;
    private String name;

    private StatusBar statusBar;

    private JPanel jp;
    private JScrollPane sc;

    private int level_1,level_2,level_3,level_4,level_5,level_6,level_7;
    private int store_1_Level,store_2_Level,store_3_Level;

    private BrownyShop brownyShop = new BrownyShop();
    private DodoShop dodoShop = new DodoShop();
    private GreenyShop greenyShop = new GreenyShop();
    private FlyMeToTheMoonShop flyMeToTheMoonShop = new FlyMeToTheMoonShop();
    private RapterShop rapterShop = new RapterShop();
    private ReddyShop reddyShop = new ReddyShop();
    private StormFlyShop stormFlyShop = new StormFlyShop();

    private WaterShop waterShop = new WaterShop();
    private RestaurantShop restaurantShop = new RestaurantShop();
    private IcecreamShop icecreamShop = new IcecreamShop();

    private MapMenuPanel mapMenuPanel;
    private int exp;

    public GamePanel(CardLayout cardLayout, JPanel mainPanel) {
        super("bggame");

        jp = new JPanel();
        jp.setLayout(new GridLayout(4,3));
        jp.setOpaque(false);

        greenyShop.addActionListener(_->{
            int l =  level_1;
            if(l<10 && greenyShop.getMoney() <= money){
                money -= greenyShop.getMoney();
                ++l;
                animal_1.put("Level", l);
                exp+=200;
            }
        });
        jp.add(greenyShop);
        brownyShop.addActionListener(_->{
            int l =  level_2;
            if(l<10 && brownyShop.getMoney() <= money){
                money -= brownyShop.getMoney();
                ++l;
                animal_2.put("Level", l);
                exp+=200;
            }
        });
        jp.add(brownyShop);
        dodoShop.addActionListener(_->{
            int l =  level_7;
            if(l<10 && dodoShop.getMoney() <= money){
                money -= dodoShop.getMoney();
                ++l;
                animal_7.put("Level", l);
                exp+=200;
            }
        });
        jp.add(dodoShop);
        flyMeToTheMoonShop.addActionListener(_->{
            int l =  level_5;
            if(l<10 && flyMeToTheMoonShop.getMoney() <= money){
                money -= flyMeToTheMoonShop.getMoney();
                ++l;
                animal_5.put("Level", l);
                exp+=200;
            }
        });
        jp.add(flyMeToTheMoonShop);
        rapterShop.addActionListener(_->{
            int l =  level_6;
            if(l<10 && rapterShop.getMoney() <= money){
                money -= rapterShop.getMoney();
                ++l;
                animal_6.put("Level", l);
                exp+=200;
            }
        });
        jp.add(rapterShop);
        reddyShop.addActionListener(_->{
            int l =  level_4;
            if(l<10 && reddyShop.getMoney() <= money){
                money -= reddyShop.getMoney();
                ++l;
                animal_4.put("Level", l);
                exp+=200;
            }
        });
        jp.add(reddyShop);
        stormFlyShop.addActionListener(_->{
            int l =  level_3;
            if(l<10 && stormFlyShop.getMoney() <= money){
                money -= stormFlyShop.getMoney();
                ++l;
                animal_3.put("Level", l);
                exp+=200;
            }
        });
        jp.add(stormFlyShop);
        waterShop.addActionListener(_->{
            int l =  store_2_Level;
            if(l<10 && waterShop.getMoney() <= money){
                money -= waterShop.getMoney();
                ++l;
                store_2.put("Level", l);
                exp+=30;
            }
        });
        jp.add(waterShop);
        restaurantShop.addActionListener(_->{
            int l =  store_1_Level;
            if(l<10 && restaurantShop.getMoney() <= money){
                money -= restaurantShop.getMoney();
                ++l;
                store_1.put("Level", l);
                exp+=150;
            }
        });
        jp.add(restaurantShop);
        jp.add(new JPanel() {{
            setOpaque(false);
        }});
        icecreamShop.addActionListener(_->{
            int l =  store_3_Level;
            if(l<10 && icecreamShop.getMoney() <= money){
                money -= icecreamShop.getMoney();
                ++l;
                store_3.put("Level", l);
                exp+=200;
            }
        });
        jp.add(icecreamShop);
        jp.add(new JPanel() {{
            setOpaque(false);
        }});

        sc = new JScrollPane(jp, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sc.setBounds(350, 100, 650, 540);
        sc.setOpaque(false);
        sc.getViewport().setOpaque(false);
        sc.setBorder(null);
        sc.setVisible(false);
        add(sc);

      
        backButton = new JButton("Back Game");

        setLayout(null);
        backButton.setLocation(600, 300);
        backButton.setSize(100, 100);
        backButton.setToolTipText("Back");
        backButton.addActionListener(_ -> {
            randomCharacterThread.cleanerList();
            this.stop_Game();
            cardLayout.show(mainPanel, "MapMenuPanel");
        });
        add(backButton);

        Start s = new Start();
        s.setLocation(1150, 0);
        s.addActionListener(_ -> {
            setComponentZOrder(sc, 0);
            sc.setVisible(!sc.isVisible());
        });

        statusBar = new StatusBar();
        add(statusBar);
        setComponentZOrder(statusBar, 0);

        // add(t);
        add(s);
        allCage_Add();

    }

    public void start_Game(DataUser dataUser, int index,MapMenuPanel mapMenuPanel) {
        this.mapMenuPanel = mapMenuPanel;
        this.dataUser = dataUser;
        dataMap = dataUser.getDataUser().get(index);

        money = dataMap.getMoney();
        level = dataMap.getLevel();
        name = dataMap.getName();
        exp = dataMap.getExp();


        randomCharacterThread = new RandomCharacterThread(this, charactersList);
        cleanerCharacterThread = new CleanerCharacterThraed(this, true, charactersList);
        checkCharacter = new CheckCharacter(randomCharacterThread, charactersList);
        checkCharacter.setMax_Character(dataMap.getMax_Character());
        addAnimalThread = new Thread(() -> {
            try {
                while (true) {
                    loadAnimal();
                    loadStore();
                    loadCage();
                    evoEvo();
                    evoLevel();
                    statusBar.setMoney(money);
                    statusBar.setLevel(level);
                    statusBar.setExp(exp);
                    randomCharacterThread.setLevel(level);
                    // money+= randomCharacterThread.getMoney();
                    statusBar.setName(name);
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
            }
        });
        addAnimalThread.start();
        randomCharacterThread.start();
        cleanerCharacterThread.start();
        checkCharacter.start();

        greenyShop.startThread();
        brownyShop.startThread();
        flyMeToTheMoonShop.startThread();
        reddyShop.startThread();
        stormFlyShop.startThread();
        rapterShop.startThread();
        dodoShop.startThread();
        restaurantShop.startThread();
        waterShop.startThread();
        icecreamShop.startThread();
    }

    public void stop_Game() {
        dataMap.setMoney((int) money);
        dataMap.setExp(exp);
        dataMap.setLevel(level);
        new DataBase(dataUser);
        randomCharacterThread.interrupt();
        cleanerCharacterThread.interrupt();
        checkCharacter.interrupt();
        addAnimalThread.interrupt();
        saveAnimal();
        saveStore();
        mapMenuPanel.loadMap();
        System.out.println("GameStop");
    }

    private void allCage_Add() {
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
        level_1 = (int) animal_1.get("Level");
        int evo_2 = (int) animal_2.get("Evo");
        level_2 = (int) animal_2.get("Level");
        int evo_3 = (int) animal_3.get("Evo");
        level_3 = (int) animal_3.get("Level");
        int evo_4 = (int) animal_4.get("Evo");
        level_4 = (int) animal_4.get("Level");
        int evo_5 = (int) animal_5.get("Evo");
        level_5 = (int) animal_5.get("Level");
        int evo_6 = (int) animal_6.get("Evo");
        level_6 = (int) animal_6.get("Level");
        int evo_7 = (int) animal_7.get("Evo");
        level_7 = (int) animal_7.get("Level");

        if (level_1 > 0) {
            if (greenny == null) {
                c1.setVisible(true);
                greenny = new Greenny(this);
                add(greenny);
                setComponentZOrder(greenny, 1);
                greenny.setEvo(evo_1);
                greenny.setLevel(level_1);
                greenny.startMove();
            }
            greenny.setToolTipText("Level: " + greenny.getLevel());
            greenny.setEvo(evo_1);
            greenny.setLevel(level_1);
        }
        greenyShop.setLevel(level_1);

        if (level_2 > 0) {
            if (browny == null) {
                c2.setVisible(true);
                browny = new Browny(this);
                add(browny);
                setComponentZOrder(browny, 1);
                browny.setEvo(evo_2);
                browny.setLevel(level_2);
                browny.startMove();
            }
            browny.setToolTipText("Level: "+browny.getLevel());
            browny.setEvo(evo_2);
            browny.setLevel(level_2);
        }
        brownyShop.setLevel(level_2);

        if (level_3 > 0) {
            if (stormFly == null) {
                c6.setVisible(true);
                stormFly = new StormFly(this);
                add(stormFly);
                setComponentZOrder(stormFly, 1);
                stormFly.setEvo(evo_3);
                stormFly.setLevel(level_3);
                stormFly.startMove();
            }
            stormFly.setToolTipText("Level: "+stormFly.getLevel());
            stormFly.setEvo(evo_3);
            stormFly.setLevel(level_3);
        }
        stormFlyShop.setLevel(level_3);

        if (level_4 > 0) {
            if (reddy == null) {
                c3.setVisible(true);
                reddy = new Reddy(this);
                add(reddy);
                setComponentZOrder(reddy, 1);
                reddy.setEvo(evo_4);
                reddy.setLevel(level_4);
                reddy.startMove();
            }
            reddy.setToolTipText("Level: "+reddy.getLevel());
            reddy.setEvo(evo_4);
            reddy.setLevel(level_4);
        }
        reddyShop.setLevel(level_4);

        if (level_5 > 0) {
            if (flyMeToTheMoon == null) {
                c5.setVisible(true);
                flyMeToTheMoon = new FlyMeToTheMoon(this);
                add(flyMeToTheMoon);
                setComponentZOrder(flyMeToTheMoon, 1);
                flyMeToTheMoon.setEvo(evo_5);
                flyMeToTheMoon.setLevel(level_5);
                flyMeToTheMoon.startMove();
            }
            flyMeToTheMoon.setToolTipText("Level: "+flyMeToTheMoon.getLevel());
            flyMeToTheMoon.setEvo(evo_5);
            flyMeToTheMoon.setLevel(level_5);
        }
        flyMeToTheMoonShop.setLevel(level_5);

        if (level_6 > 0) {
            if (rapter == null) {
                c7.setVisible(true);
                rapter = new Rapter(this);
                add(rapter);
                setComponentZOrder(rapter, 1);
                rapter.setEvo(evo_6);
                rapter.setLevel(level_6);
                rapter.startMove();
            }
            rapter.setToolTipText("Level: "+rapter.getLevel());
            rapter.setEvo(evo_6);
            rapter.setLevel(level_6);
        }
        rapterShop.setLevel(level_6);

        if (level_7 > 0) {
            if (dodo == null) {
                c4.setVisible(true);
                dodo = new Dodo(this);
                add(dodo);
                setComponentZOrder(dodo, 1);
                dodo.setEvo(evo_7);
                dodo.setLevel(level_7);
                dodo.startMove();
            }
            dodo.setToolTipText("Level: "+dodo.getLevel());
            dodo.setEvo(evo_7);
            dodo.setLevel(level_7);
        }
        dodoShop.setLevel(level_7);
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
            greenyShop.stopThread();
        }
        if (browny != null) {
            c2.setVisible(false);
            browny.stopMove();
            remove(browny);
            browny = null;
            brownyShop.stopThread();
        }
        if (stormFly != null) {
            c6.setVisible(false);
            stormFly.stopMove();
            remove(stormFly);
            stormFly = null;
            stormFlyShop.stopThread();
        }
        if (reddy != null) {
            c3.setVisible(false);
            reddy.stopMove();
            remove(reddy);
            reddy = null;
            reddyShop.stopThread();
        }

        if (flyMeToTheMoon != null) {
            c5.setVisible(false);
            flyMeToTheMoon.stopMove();
            remove(flyMeToTheMoon);
            flyMeToTheMoon = null;
            flyMeToTheMoonShop.stopThread();
        }


        if (rapter != null) {
            c7.setVisible(false);
            rapter.stopMove();
            remove(rapter);
            rapter = null;
            rapterShop.stopThread();
        }

        if (dodo != null) {
            c4.setVisible(false);
            dodo.stopMove();
            remove(dodo);
            dodo = null;
            dodoShop.stopThread();
        }
    }

    @SuppressWarnings("unchecked")
    private void loadStore() {
        store_1 = (HashMap<String, Object>) dataMap.getStore().get("Store_1");
        store_2 = (HashMap<String, Object>) dataMap.getStore().get("Store_2");
        store_3 = (HashMap<String, Object>) dataMap.getStore().get("Store_3");
        store_1_Level = (int) store_1.get("Level");
        int store_1_Evo = (int) store_1.get("Evo");
        store_2_Level = (int) store_2.get("Level");
        int store_2_Evo = (int) store_2.get("Evo");
        store_3_Level = (int) store_3.get("Level");
        int store_3_Evo = (int) store_3.get("Evo");

        if (store_1_Level > 0) {
            if (food == null) {
                food = new Food();
                add(food);
                food.setEvo(store_1_Evo);
                food.setLevel(store_1_Level);
                food.startStore();


                money_Food = new Thread(()->{
                    try{
                        while (true) { 
                            Thread.sleep(food.getTime());
                            money += food.getMoney_Profit();
                            exp += 30;
                        }
                    } catch (InterruptedException e) {
                    }
                });
                money_Food.start();
            }
            food.setToolTipText("Level: "+food.getLevel());
            food.setEvo(store_1_Evo);
            food.setLevel(store_1_Level);
        }
        restaurantShop.setLevel(store_1_Level);

        if (store_2_Level > 0) {
            if (water == null) {
                water = new Water();
                add(water);
                water.setEvo(store_2_Evo);
                water.setLevel(store_2_Level);
                water.startStore();

                money_Water = new Thread(()->{
                    try{
                        while (true) { 
                            Thread.sleep(water.getTime());
                            money += water.getMoney_Profit();
                            exp += 30;
                        }
                    } catch (InterruptedException e) {
                    }
                });
                money_Water.start();
            }
            water.setToolTipText("Level: "+water.getLevel());
            water.setEvo(store_2_Evo);
            water.setLevel(store_2_Level);
        }
        waterShop.setLevel(store_2_Level);

        if (store_3_Level > 0) {
            if (icream == null) {
                icream = new Icream();
                add(icream);
                icream.setEvo(store_3_Evo);
                icream.setLevel(store_3_Level);
                icream.startStore();


                money_Icream = new Thread(()->{
                    try{
                        while (true) { 
                            Thread.sleep(icream.getTime());
                            money += icream.getMoney_Profit();
                            exp += 30;
                        }
                    } catch (InterruptedException e) {
                    }
                });
                money_Icream.start();
            }
            icream.setToolTipText("Level: "+icream.getLevel());
            icream.setEvo(store_3_Evo);
            icream.setLevel(store_3_Level);
        }
        icecreamShop.setLevel(store_3_Level);
    }

    private void saveStore() {
        if (food != null) {
            money_Food.interrupt();
            food.stopStore();
            remove(food);
            food = null;
            restaurantShop.setLevel(0);
            restaurantShop.stopThread();
        }

        if (water != null) {
            money_Water.interrupt();
            water.stopStore();
            remove(water);
            water = null;
            waterShop.setLevel(0);
            waterShop.stopThread();
        }

        if (icream != null) {
            money_Icream.interrupt();
            icream.stopStore();
            remove(icream);
            icream = null;
            icecreamShop.setLevel(0);
            icecreamShop.stopThread();
        }
    }

    private void evoEvo(){
        if(level_1<4){
            animal_1.put("Evo", 0);
        }else if(level_1>=4 && level_1<7){
            animal_1.put("Evo", 1);
        }
        else{
            animal_1.put("Evo", 2);
        }

        if(level_2<4){
            animal_2.put("Evo", 0);
        }else if(level_2>=4 && level_2<7){
            animal_2.put("Evo", 1);
        }
        else{
            animal_2.put("Evo", 2);
        }

        if(level_3<4){
            animal_3.put("Evo", 0);
        }else if(level_3>=4 && level_3<7){
            animal_3.put("Evo", 1);
        }
        else{
            animal_3.put("Evo", 2);
        }

        if(level_4<4){
            animal_4.put("Evo", 0);
        }else if(level_4>=4 && level_4<7){
            animal_4.put("Evo", 1);
        }
        else{
            animal_4.put("Evo", 2);
        }

        if(level_5<4){
            animal_5.put("Evo", 0);
        }else if(level_5>=4 && level_5<7){
            animal_5.put("Evo", 1);
        }
        else{
            animal_5.put("Evo", 2);
        }

        if(level_6<4){
            animal_6.put("Evo", 0);
        }else if(level_6>=4 && level_6<7){
            animal_6.put("Evo", 1);
        }
        else{
            animal_6.put("Evo", 2);
        }

        if(level_7<4){
            animal_7.put("Evo", 0);
        }else if(level_7>=4 && level_7<7){
            animal_7.put("Evo", 1);
        }
        else{
            animal_7.put("Evo", 2);
        }

        if(store_1_Level<4){
            store_1.put("Evo", 0);
        }else if(store_1_Level>=4 && store_1_Level<7){
            store_1.put("Evo", 1);
        }
        else{
            store_1.put("Evo", 2);
        }

        if(store_2_Level<4){
            store_2.put("Evo", 0);
        }else if(store_2_Level>=4 && store_2_Level<7){
            store_2.put("Evo", 1);
        }
        else{
            store_2.put("Evo", 2);
        }

        if(store_3_Level<4){
            store_3.put("Evo", 0);
        }else if(store_3_Level>=4 && store_3_Level<7){
            store_3.put("Evo", 1);
        }
        else{
            store_3.put("Evo", 2);
        }
    }

    public void setMoney(double money){
        this.money = money;
    }

    public double getMoney(){
        return this.money;
    }

    public void evoLevel(){
        if(exp>=(level*700) && level<30){
            level+=1;
            exp = 0;
        }
    }

    public void setExp(int exp){
        this.exp = exp;
    }

    public int getExp(){
        return this.exp;
    }
}
