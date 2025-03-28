package AllTread.GameThread;

import AllMom.MomCharacter;
import Link_Panel.GamePanel;
import java.util.ArrayList;
import java.util.Iterator;

public class CleanerCharacterThraed extends Thread {
    private ArrayList<MomCharacter> charactersList;
    private GamePanel g;
    private boolean running;

    public CleanerCharacterThraed(GamePanel g,boolean b,ArrayList<MomCharacter> charactersList) {
        this.charactersList = charactersList;
        this.g = g;
        this.running = b;
    }

    @Override
    public void run() {
        try {
            while (true) {
                cleanerList_inGame();
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void setRunning(boolean b) {
        this.running = b;
    }

    private void cleanerList_inGame() {
        Iterator<MomCharacter> iterator = charactersList.iterator();
        while (iterator.hasNext()) {
            MomCharacter m = iterator.next();
            if (m.getX() < -1 || m.getX() >= 1360) {
                m.stopMove();
                g.remove(m);
                iterator.remove();
                g.repaint();
                System.out.println("NPC = " + (charactersList.size() + 1));
            }
        }
    }
}
