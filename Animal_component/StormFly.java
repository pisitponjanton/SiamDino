package Animal_component;

import AllMom.MomAnimal;
import Link_Panel.GamePanel;

public class StormFly extends MomAnimal{
    private Thread thread;
    public StormFly(GamePanel g){
        super("StormFly",750 ,100 ,400 ,g);
        thread = new Thread(() -> {
            try {
                Thread.sleep(100);
                while (true) {
                    switch (getEvo()) {
                        case 0 -> setSize(150, 83);
                        case 1 -> setSize(170, 94);
                        case 2 -> setSize(180, 100);
                        default -> {
                        }
                    }
                }
            } catch (InterruptedException e) {
            }
        });
        thread.start();
    }
    public void stopThread(){
        this.thread.interrupt();
    }
}
