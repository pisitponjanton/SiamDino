package AllMom;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public final class Animation{
    private int x;
    private int y;
    private int moving;
    private double  starty;
    private JComponent ob;

    public Animation(JComponent ob,int moving){
        this.ob = ob;
        Point location = this.ob.getLocation();
        this.x = location.x;
        this.y = location.y;
        this.moving = moving;
        this.starty = y;
        animationY(moving);
    }

    protected void animationY(int i) {
        Timer timer = new Timer(10, (ActionEvent e) -> {
            switch (moving) {
                case 0 -> {
                    if (starty < y + 10) {
                        starty += 1;
                    } else {
                        moving = 1;
                    }
                }
                case 1 -> {
                    if (starty > y - 30) {
                        starty -= 0.5;
                    } else {
                        moving = 2;
                    }
                }
                default -> {
                    if (starty < y) {
                        starty += 0.25;
                    } else {
                        if(i == 0){
                            ((Timer) e.getSource()).stop();
                        }else{
                            moving = 0;
                        }
                    }
                }
            }
            ob.setLocation(this.x ,(int) starty);
        });

        timer.start();
    }
}
