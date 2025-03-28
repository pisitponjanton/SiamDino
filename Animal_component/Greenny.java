package Animal_component;

import AllMom.MomAnimal;
import Link_Panel.GamePanel;

public class Greenny extends MomAnimal {
    private Thread thread;
    public Greenny(GamePanel g) {
        super("Greenny", 500, 600,100,g);
        thread = new Thread(() -> {
            try {
                Thread.sleep(100);
                while (true) {
                    switch (getEvo()) {
                        case 0 -> setSize(150, 79);
                        case 1 -> setSize(114, 100);
                        case 2 -> setSize(86, 100);
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
