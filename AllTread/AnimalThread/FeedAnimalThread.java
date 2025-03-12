package AllTread.AnimalThread;

import AllMom.MomAnimal;

public class FeedAnimalThread extends Thread{
    private boolean running;
    private MoveThread moveThread;
    private AnimationThread animationThread;
    private MomAnimal m;

    public FeedAnimalThread(MoveThread moveThread,AnimationThread animationThread,MomAnimal m){
        this.moveThread = moveThread;
        this.animationThread = animationThread;
        this.m = m;
    }
    @Override
    public void run(){
        try {
            while (true) {
                Thread.sleep(getSleep());
                stopAll();
                setRunning();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void setRunning(){
        try {
            while (running){
                wait();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public synchronized void running(){
        this.running = false;
        System.out.println("+++");
        notify();
    }
    
    public void stopping(){
        this.running = true;
    }

    public void stopAll(){
        moveThread.stopping();
        animationThread.stopping();
        stopping();
    }

    public int getSleep(){
        if(m.getEvo() == 0 ){
            return 180000;
        }else if(m.getEvo() == 1){
            return 120000;
        }else{
            return 60000;
        }
    }

}
