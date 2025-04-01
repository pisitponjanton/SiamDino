package AllTread.GameThread;

import AllMom.MomCharacter;
import Character_component.*;
import Link_Panel.GamePanel;
import Sound.SoundEasterEgg;
import Sound.SoundPop;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class RandomCharacterThread extends Thread {
    private ArrayList<MomCharacter> charactersList;
    private GamePanel g;
    private boolean running;
    private double money;
    private int level = 1;

    public RandomCharacterThread(GamePanel g,ArrayList<MomCharacter> charactersList) {
        this.g = g;
        this.charactersList = charactersList;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(5000);
                setRunning();
                setMoney();
                g.setMoney(g.getMoney()+money);
                startRandomCharacterThread();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void setRunning(){
        try {
            while (!running){ 
                wait();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void setLevel(int level){
        this.level = level;
    }

    public int getLevel(){
        return this.level;
    }

    public double getMoney(){
        return this.money;
    }

    private void setMoney(){
        switch (level) {
            case 1 -> money = 99;
            case 2 -> money = 119;
            case 3 -> money = 139;
            case 4 -> money = 169;
            case 5 -> money = 199;
            case 6 -> money = 249;
            case 7 -> money = 299;
            default -> money = 399;
        }
    }

    public synchronized void running(){
        this.running = true;
        notify();
    }

    public void stopping(){
        this.running = false;
    }

    public synchronized void startRandomCharacterThread() {
        Random rand = new Random();
        int random_Character = rand.nextInt(6);
        boolean random_Move = rand.nextBoolean();
        int random_Move_int = random_Move ? 0 : 1350;
        MomCharacter m = switch (random_Character) {
            case 0 -> new Mrbean(random_Move_int, 330, random_Move_int > 0 ? 1 : 0);
            case 1 -> new Snowkuy(random_Move_int, 330, random_Move_int > 0 ? 1 : 0);
            case 2 -> new Mario(random_Move_int, 330, random_Move_int > 0 ? 1 : 0);
            case 3 -> new Chawaydagong(random_Move_int, 330, random_Move_int > 0 ? 1 : 0);
            case 4 -> new Fuy(random_Move_int, 330, random_Move_int > 0 ? 1 : 0);
            default -> new Bank(random_Move_int, 330, random_Move_int > 0 ? 1 : 0);
        };
        if(m instanceof Bank ){
            SoundEasterEgg.play();
        }
        System.out.println("NPC = " + (charactersList.size() + 1));
        SoundPop.play();
        g.add(m);
        g.setComponentZOrder(m, 1);
        charactersList.add(m);
        g.repaint();
    }

    public void cleanerList() {
        Iterator<MomCharacter> iterator = charactersList.iterator();
        while (iterator.hasNext()) {
            MomCharacter m = iterator.next();
            m.stopMove();
            g.remove(m);
            iterator.remove();
            g.repaint();
            System.out.println("NPC = " + (charactersList.size() + 1));
        }
    }
}
