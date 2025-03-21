package Animal_component;

import AllMom.MomAnimal;
import Link_Panel.GamePanel;

public class Rapter extends MomAnimal {
    public Rapter(GamePanel g) {
        super("Rapter", 380, 100,120,g);
        new Thread(() -> {
            try {
                Thread.sleep(100);
                while (true) {
                    switch (getEvo()) {
                        case 0 -> setSize(120, 93);
                        case 1 -> setSize(120, 93);
                        case 2 -> setSize(172, 140);
                        default -> {
                        }
                    }
                }
            } catch (InterruptedException e) {
            }
        }).start();
    }
}
