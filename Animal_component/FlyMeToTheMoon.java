package Animal_component;

import AllMom.MomAnimal;
import Link_Panel.GamePanel;

public class FlyMeToTheMoon extends MomAnimal{
    private Thread thread;
    public FlyMeToTheMoon(GamePanel g){
        super("FlyMeToTheMoon", 1150, 500, 60,g);
        thread = new Thread(() -> {
            try {
                Thread.sleep(100);
                while (true) {
                    switch (getEvo()) {
                        case 0 -> setSize(74, 100);
                        case 1 -> setSize(116, 110);
                        case 2 -> setSize(150, 145);
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
