package Animal_component;

import AllMom.MomAnimal;

public class Greenny extends MomAnimal {
    public Greenny() {
        super("Greenny", 500, 600,100);
        new Thread(() -> {
            try {
                Thread.sleep(100);
                while (true) {
                    if (getEvo() == 0) {
                        setSize(150, 66);
                    } else if (getEvo() == 1) {
                        setSize(86, 100);
                    }
                }
            } catch (InterruptedException e) {
            }
        }).start();
    }
}
