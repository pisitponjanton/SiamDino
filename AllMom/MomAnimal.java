package AllMom;

import AllTread.AnimalThread.AnimationThread;
import AllTread.AnimalThread.FeedAnimalThread;
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
    private ArrayList<ArrayList<Image>> imageEvo = new ArrayList<>();
    private int currentFrame;
    private int evo;
    private int level;
    private int maxMoveX;
    private int maxMoveY;
    private int moveX;
    private int moveY;
    private int movemaxX;
    private int move;

    private MoveThread moveThread;
    private AnimationThread animationThread;
    private FeedAnimalThread feedAnimalThread;

    public MomAnimal(String namePath, int moveX, int moveY, int movemaxX) {
        this.namePath = namePath;
        this.moveX = moveX;
        this.moveY = moveY;
        this.movemaxX = movemaxX;
        this.maxMoveX = moveX;
        this.maxMoveY = moveY;
        this.addImage();
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (moveThread.getRunning()) {
                    moveThread.running();
                    animationThread.running();
                    feedAnimalThread.running();
                }
            }
        });
        setOpaque(false);
    }

    public void setEvo(int evo) {
        this.evo = evo;
    }

    public int getEvo() {
        return this.evo;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!imageEvo.isEmpty()) {
            g.drawImage(imageEvo.get(evo).get(currentFrame), 0, 0, getWidth(), getHeight(), this);
        }
    }

    public void addImage() {
        for (int ev = 1; ev <= 3; ev++) {
            ArrayList<Image> imageList = new ArrayList<>();
            for (int i = 1; i <= 6; i++) {
                try {
                    Image img = ImageIO
                            .read(new File("img/Animal/" + this.namePath + "/evo" + ev + "/Character" + i + ".png"));
                    imageList.add(img);
                } catch (IOException e) {
                }
            }
            imageEvo.add(imageList);
        }
    }

    public void startMove() {
        moveThread = new MoveThread(this);
        animationThread = new AnimationThread(this);
        feedAnimalThread = new FeedAnimalThread(moveThread, animationThread, this);
        moveThread.start();
        animationThread.start();
        feedAnimalThread.start();
    }

    public void stopMove() {
        moveThread.interrupt();
        animationThread.interrupt();
        feedAnimalThread.interrupt();
    }

    public void howMove() {
        if (this.move == 0) {
            currentFrame = 3 + (currentFrame + 1) % 3;
        } else {
            currentFrame = (currentFrame + 1) % 3;
        }

    }

    public void moveLoop() {
        int x = getX();
        int speed = 1;

        if (x >= maxMoveX + movemaxX) {
            this.move = 0;
        } else if (x <= maxMoveX) {
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
