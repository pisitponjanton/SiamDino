package Animal_component;

import AllMom.MomAnimal;

public class FlyMeToTheMoon extends MomAnimal{
    public FlyMeToTheMoon(){
        super("FlyMeToTheMoon", 1150, 500, 60);
        new Thread(() -> {
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
        }).start();
    }
}
