package AllTread.CharacterThread;

import AllMom.MomCharacter;

public class AnimationThread extends Thread {
    private boolean running;
    private MomCharacter mc;

    public AnimationThread(MomCharacter mc) {
        this.mc = mc;
    }

    @Override
    public void run() {
        try {
            while (true) {
                setRunning();
                Thread.sleep(100);
                mc.howMove();
                mc.repaint();
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
