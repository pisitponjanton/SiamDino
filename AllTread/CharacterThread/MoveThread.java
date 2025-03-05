package AllTread.CharacterThread;

import AllMom.MomCharacter;

public class MoveThread extends Thread {
    private boolean running;
    private MomCharacter mc;

    public MoveThread(MomCharacter mc) {
        this.mc = mc;
    }

    @Override
    public void run() {
        try {
            while (true) {
                setRunning();
                Thread.sleep(50);
                switch (mc.getmoveXY()) {
                    case 0 -> {
                        mc.setMove(1);
                        mc.characterMoveR();
                    }
                    case 1 -> {
                        mc.setMove(2);
                        mc.characterMoveL();
                    }
                    case 2 -> {
                        mc.setMove(3);
                        mc.characterMoveD();
                    }
                    case 3 -> {
                        mc.setMove(4);
                        mc.characterMoveU();
                    }
                    default -> {
                        mc.setMove(0);
                    }
                }
                mc.moveRandom();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void setRunning() {
        try {
            while (running) {
                wait();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void running() {
        this.running = true;
        notify();
    }

    public void stopping() {
        this.running = false;
    }
}
