package AllTread.GameThread;

import AllMom.MomCharacter;
import java.util.ArrayList;

public class CheckCharacter extends Thread{
    private boolean running;
    private RandomCharacterThread randomCharacterThread;
    private ArrayList<MomCharacter> charactersList;
    private int max_character;

    public CheckCharacter(RandomCharacterThread randomCharacterThread,ArrayList<MomCharacter> charactersList){
        this.randomCharacterThread = randomCharacterThread;
        this.charactersList = charactersList;
    }

    @Override
    public void run(){
        try {
            while (true) { 
                setRunning();
                if (charactersList.size() < max_character) {
                    randomCharacterThread.running();
                } else {
                    randomCharacterThread.stopping();
                }
                Thread.sleep(60);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void setMax_Character(int max_character){
        this.max_character = max_character;
    }

    public synchronized void setRunning(){
        try {
            while (running) { 
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
}
