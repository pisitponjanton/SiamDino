package Animal_component;

import AllMom.MomAnimal;
import Link_Panel.GamePanel;

public class Dodo extends MomAnimal{
    private Thread thread;
    public Dodo(GamePanel g){
        super("Dodo", 100, 210,120,g);
        thread = new Thread(() -> {
            try {
                Thread.sleep(100);
                while (true) {
                    switch (getEvo()) {
                        case 0 -> setSize(70, 65);
                        case 1 -> setSize(99, 120);
                        case 2 -> setSize(156, 130);
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
