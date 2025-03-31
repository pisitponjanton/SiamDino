package AllTread.AnimalThread;

import AllMom.FontLoader;
import AllMom.MomAnimal;
import Sound.SoundHungry;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class FeedAnimalThread extends Thread{
    private boolean running;
    private MoveThread moveThread;
    private AnimationThread animationThread;
    private MomAnimal m;
    private JLabel label;
    private Thread aThread;

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
                showMessage();
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
        Random random = new Random();
        return switch (random.nextInt(5)){
            case 0 -> 180000;
            case 1 -> 120000;
            case 2 -> 100000;
            case 3 -> 80000;
            default -> 60000;
        };
    }

    public void showMessage(){
        label = new JLabel("Hungry");
        label.setOpaque(true);
        label.setForeground(Color.WHITE);
        label.setBackground(Color.BLACK);
        label.setToolTipText("Click ME");
        label.setFont(FontLoader.loadFont(14));
        label.setBounds(50, 50, 30, 30);
        SoundHungry.play();
        m.add(label);
        m.revalidate();
        m.repaint();
    }

}
