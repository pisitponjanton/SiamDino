package AllTread.AnimalThread;

import AllMom.MomAnimal;

public class MoveThread extends Thread{
    private boolean running;
    private MomAnimal a;

    public MoveThread(MomAnimal a){
        this.a = a;
    }

    @Override
    public void run() {
        try {
            while (true) {
                setRunning();
                Thread.sleep(60);
                startMove();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void startMove(){
        this.a.moveLoop();
    }

    public boolean getRunning(){
        return this.running;
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
        this.running = false;
        notify();
    }
    
    public void stopping() {
        this.running = true;
    }
}
