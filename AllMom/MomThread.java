package AllMom;

public class MomThread extends Thread{
    private boolean running;
    @Override
    public void run(){
        try {
            while (true) { 
                setRunning();
            }
        } catch (Exception e) {
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
        notify();
    }
    
    public void stopping(){
        this.running = true;
    }
}
