package AllTread.GameThread;

import AllMom.MomCharacter;
import Character_component.Bank;
import Character_component.Mario;
import Character_component.Mrbean;
import Character_component.Snowkuy;
import Link_Panel.GamePanel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class RandomCharacterThread extends Thread {
    private ArrayList<MomCharacter> charactersList;
    private GamePanel g;
    private boolean running;

    public RandomCharacterThread(GamePanel g,ArrayList<MomCharacter> charactersList) {
        this.g = g;
        this.charactersList = charactersList;
    }

    @Override
    public void run() {
        try {
            while (true) {
                setRunning();
                startRandomCharacterThread();
                Thread.sleep(3500);
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

    public synchronized void running(){
        this.running = true;
        notify();
    }

    public void stopping(){
        this.running = false;
    }

    public synchronized void startRandomCharacterThread() {
        Random rand = new Random();
        int random_Character = rand.nextInt(4);
        boolean random_Move = rand.nextBoolean();
        int random_Move_int = random_Move ? 0 : 1350;
        MomCharacter m = switch (random_Character) {
            case 0 -> new Mrbean(random_Move_int, 330, random_Move_int > 0 ? 1 : 0);
            case 1 -> new Snowkuy(random_Move_int, 330, random_Move_int > 0 ? 1 : 0);
            case 2 -> new Mario(random_Move_int, 330, random_Move_int > 0 ? 1 : 0);
            default -> new Bank(random_Move_int, 330, random_Move_int > 0 ? 1 : 0);
        };
        System.out.println("NPC = " + (charactersList.size() + 1));
        g.add(m);
        g.setComponentZOrder(m, 1);
        charactersList.add(m);
        g.repaint();
    }

    public void cleanerList() {
        Iterator<MomCharacter> iterator = charactersList.iterator();
        while (iterator.hasNext()) {
            MomCharacter m = iterator.next();
            g.remove(m);
            iterator.remove();
            g.repaint();
            System.out.println("NPC = " + (charactersList.size() + 1));
        }
    }
}
