package Animal_component;

import AllMom.MomAnimal;
import Link_Panel.GamePanel;

public class Reddy extends MomAnimal{
    public Reddy(GamePanel g){
        super("Reddy", 50, 550,200,g);
        new Thread(() -> {
            try {
                Thread.sleep(100);
                while (true) {
                    switch (getEvo()) {
                        case 0 -> setSize(42, 50);
                        case 1 -> setSize(150, 134);
                        case 2 -> setSize(180, 159);
                        default -> {
                        }
                    }
                }
            } catch (InterruptedException e) {
            }
        }).start();
    }
}
