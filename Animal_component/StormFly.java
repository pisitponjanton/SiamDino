package Animal_component;

import AllMom.MomAnimal;

public class StormFly extends MomAnimal{
    public StormFly(){
        super("StormFly",750 ,100 ,400 );
        new Thread(() -> {
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
        }).start();
    }
}
