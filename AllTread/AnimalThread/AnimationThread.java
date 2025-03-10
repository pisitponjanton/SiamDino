package AllTread.AnimalThread;

import AllMom.MomAnimal;

public class AnimationThread extends Thread{
    private boolean running;
    private MomAnimal a;

    public AnimationThread(MomAnimal a){
        this.a = a;
    }

    @Override
    public void run(){
        try {
            while (true) { 
                setRunning();
                startAnimation();
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void startAnimation(){
        this.a.howMove();
        this.a.repaint();
    }

    public boolean getRunning(){
        return this.running;
    }
    
    public synchronized void setRunning(){
        try {
            while (running) { 
                wait();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public synchronized void running(){
        this.running = false;
        notify();
    }
    
    public void stopping(){
        this.running = true;
    }
}
