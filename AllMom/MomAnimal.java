package AllMom;

import AllTread.AnimalThread.AnimationThread;
import AllTread.AnimalThread.MoveThread;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

public abstract class MomAnimal extends JPanel {
    private String namePath;
    private ArrayList<ArrayList<Image>> evo = new ArrayList<>();
    private int currentFrame;
    private int level;

    private int moveX;
    private int moveY;

    private int move;

    private MoveThread moveThread;
    private AnimationThread animationThread;

    public MomAnimal(String namePath, int moveX, int moveY) {
        this.namePath = namePath;
        this.moveX = moveX;
        this.moveY = moveY;
        this.addImage();
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                System.out.println("Eat");
            }
        });
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!evo.isEmpty()) {
            g.drawImage(evo.get(level).get(currentFrame), 0, 0, getWidth(), getHeight(), this);
        }
    }

    public void addImage() {
        ArrayList<Image> imageList = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            try {
                Image img = ImageIO.read(new File("img/Animal/" + this.namePath + "/Evo2/" + "Dra" + i + ".png"));
                imageList.add(img);
            } catch (IOException e) {
            }
        }
        evo.add(imageList);
    }

    public void startMove() {
        moveThread = new MoveThread(this);
        animationThread = new AnimationThread(this);
        moveThread.start();
        animationThread.start();
    }

    public void stopMove(){
        moveThread.interrupt();
        animationThread.interrupt();
    }

    public void howMove() {
        if (this.move == 0) {
            currentFrame = (currentFrame + 1) % 4;
        } else {
            currentFrame = 4 + (currentFrame + 1) % 4;
        }

    }

    public void moveLoop() {
        int x = getX();
        int speed = 5;

        if (x >= 800) {
            this.move = 0;
        } else if (x <= 500) {
            this.move = 1;
        }

        if (this.move == 1) {
            moveX += speed;
        } else {
            moveX -= speed;
        }
        setLocation(moveX, moveY);
        repaint();
    }

}
