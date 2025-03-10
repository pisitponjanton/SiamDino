package Animal_component;

import AllMom.MomAnimal;

public class Browny extends MomAnimal{
    public Browny(){
        super("Browny", 920, 550,50);
        new Thread(() -> {
            try {
                Thread.sleep(100);
                while (true) {
                    switch (getEvo()) {
                        case 0 -> setSize(150, 66);
                        case 1 -> setSize(160, 89);
                        case 2 -> setSize(170, 95);
                        default -> {
                        }
                    }
                }
            } catch (InterruptedException e) {
            }
        }).start();
    }
}
