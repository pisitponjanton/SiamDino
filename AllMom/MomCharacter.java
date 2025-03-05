package AllMom;

import AllTread.CharacterThread.AnimationThread;
import AllTread.CharacterThread.MoveThread;
import Character_component.Move;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;

public abstract class MomCharacter extends JPanel implements Move {
    private final ArrayList<Image> frames = new ArrayList<>();
    private int currentFrame = 0;
    private int move;
    private final String namePath;
    private final Random random = new Random();

    private float xOffset;
    private float yOffset;
    private float speed;
    private int moveXY;

    private AnimationThread animationThread;
    private MoveThread moveThread;

    public MomCharacter(int width, int height, int x, int y, String namePath) {
        setOpaque(false);
        setSize(width, height);
        setLocation(x, y);
        this.namePath = namePath;
        this.xOffset = x;
        this.yOffset = y;
        this.moveXY = 0;
        this.speed = 1;
        loadFrames();
    }

    public void setMove(int move){
        this.move = move;
    }

    protected void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    protected float getxOffset() {
        return this.xOffset;
    }

    protected void setSpeed(int speed) {
        this.speed = speed;
    }

    protected float getSpeed() {
        return this.speed;
    }

    public void setmoveXY(int b) {
        this.moveXY = b;
    }

    public int getmoveXY() {
        return this.moveXY;
    }

    @Override
    public void characterMoveR() {
        xOffset += speed;
        setLocation((int) xOffset, (int) this.yOffset);
    }

    @Override
    public void characterMoveL() {
        xOffset -= speed;
        setLocation((int) xOffset, (int) this.yOffset);
    }

    @Override
    public void characterMoveU() {
        yOffset -= speed;
        setLocation((int) xOffset, (int) this.yOffset);
    }

    @Override
    public void characterMoveD() {
        yOffset += speed;
        setLocation((int) xOffset, (int) this.yOffset);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!frames.isEmpty()) {
            g.drawImage(frames.get(currentFrame), 0, 0, getWidth(), getHeight(), this);
        }
    }

    private void loadFrames() {
        for (int i = 1; i <= 10; i++) {
            try {
                Image img = ImageIO.read(new File("img/Character/" + namePath + "/Character" + i + ".png"));
                frames.add(img);
            } catch (IOException e) {
            }
        }
    }

    @Override
    public void startMove(){
        animationThread = new AnimationThread(this);
        moveThread = new MoveThread(this);
        animationThread.start();
        moveThread.start();
    }

    public void howMove() {
        currentFrame = switch (this.move) {
            case 0 -> (currentFrame == 0) ? 7 : 0;
            case 1 -> (currentFrame == 1) ? 2 : 1;
            case 2 -> (currentFrame == 3) ? 4 : 3;
            case 3 -> (currentFrame == 5) ? 6 : 5;
            default -> (currentFrame == 8) ? 9 : 8;
        };
    }

    public void moveRandom() {
        Point location = getLocation();
        moveHow_Main(location);
    }

    private void moveHow_Main(Point location) {
        double x = location.x;
        double y = location.y;

        if ((x >= 1309 && x <= 1310) && (y >= 329 && y <= 330)) {
            int ran = random.nextInt(2);
            setmoveXY(ran == 0 ? 3 : 1);
        }

        if ((x >= 1309 && x <= 1310) && (y >= 239 && y <= 240)) {
            int ran = random.nextInt(3);
            switch (ran) {
                case 0 -> setmoveXY(2);
                case 1 -> setmoveXY(1);
                default -> setmoveXY(3);
            }
        }

        if ((x >= 1309 && x <= 1310) && y <= 0) {
            int ran = random.nextInt(2);
            setmoveXY(ran == 0 ? 2 : 1);
        }

        if ((x >= 1107 && x <= 1108) && (y >= 239 && y <= 240)) {
            int ran = random.nextInt(2);
            setmoveXY(ran == 0 ? 2 : 0);
        }

        if ((x >= 1107 && x <= 1108) && (y >= 329 && y <= 330)) {
            int ran = random.nextInt(4);
            switch (ran) {
                case 0 -> setmoveXY(1);
                case 1 -> setmoveXY(0);
                case 2 -> setmoveXY(3);
                default -> setmoveXY(2);
            }
        }

        if ((x >= 1107 && x <= 1108) && (y >= 414 && y <= 415)) {
            int ran = random.nextInt(3);
            switch (ran) {
                case 0 -> setmoveXY(2);
                case 1 -> setmoveXY(0);
                default -> setmoveXY(3);
            }
        }

        if ((x >= 1309 && x <= 1310) && (y >= 414 && y <= 415)) {
            setmoveXY(1);
        }

        if ((x >= 1107 && x <= 1108) && (y >= 699 && y <= 700)) {
            int ran = random.nextInt(2);
            setmoveXY(ran == 0 ? 3 : 1);
        }

        if ((x >= 894 && x <= 895) && (y >= 699 && y <= 700)) {
            int ran = random.nextInt(2);
            setmoveXY(ran == 0 ? 3 : 0);
        }

        if ((x >= 894 && x <= 895) && (y >= 479 && y <= 480)) {
            int ran = random.nextInt(2);
            setmoveXY(ran == 0 ? 1 : 2);
        }

        if ((x >= 679 && x <= 680) && (y >= 479 && y <= 480)) {
            int ran = random.nextInt(3);
            switch (ran) {
                case 0 -> setmoveXY(3);
                case 1 -> setmoveXY(0);
                default -> setmoveXY(1);
            }
        }

        if ((x >= 679 && x <= 680) && y <= 0) {
            int ran = random.nextInt(2);
            setmoveXY(ran == 0 ? 2 : 0);
        }

        if ((x >= 454 && x <= 455) && (y >= 699 && y <= 700)) {
            setmoveXY(3);
        }

        if ((x >= 454 && x <= 455) && (y >= 479 && y <= 480)) {
            int ran = random.nextInt(4);
            switch (ran) {
                case 0 -> setmoveXY(3);
                case 1 -> setmoveXY(0);
                case 2 -> setmoveXY(2);
                default -> setmoveXY(1);
            }
        }

        if ((x >= 279 && x <= 280) && (y >= 479 && y <= 480)) {
            int ran = random.nextInt(2);
            setmoveXY(ran == 0 ? 3 : 0);
        }

        if ((x >= 279 && x <= 280) && (y >= 329 && y <= 330)) {
            int ran = random.nextInt(3);
            switch (ran) {
                case 0 -> setmoveXY(2);
                case 1 -> setmoveXY(0);
                default -> setmoveXY(1);
            }
        }

        if ((x >= 454 && x <= 455) && (y >= 329 && y <= 330)) {
            int ran = random.nextInt(3);
            switch (ran) {
                case 0 -> setmoveXY(2);
                case 1 -> setmoveXY(0);
                default -> setmoveXY(1);
            }
        }

        if ((x >= 359 && x <= 360) && (y >= 329 && y <= 330)) {
            int ran = random.nextInt(3);
            switch (ran) {
                case 0 -> setmoveXY(3);
                case 1 -> setmoveXY(0);
                default -> setmoveXY(1);
            }
        }

        if ((x >= 359 && x <= 360) && (y >= 139 && y <= 140)) {
            int ran = random.nextInt(3);
            switch (ran) {
                case 0 -> setmoveXY(3);
                case 1 -> setmoveXY(1);
                default -> setmoveXY(2);
            }
        }

        if ((x >= 219 && x <= 220) && (y >= 139 && y <= 140)) {
            int ran = random.nextInt(2);
            setmoveXY(ran == 0 ? 3 : 0);
        }

        if ((x >= 219 && x <= 220) && y <= 0 ) {
            int ran = random.nextInt(2);
            setmoveXY(ran == 0 ? 2 : 0);
        }

        if ((x >= 359 && x <= 360) && y <= 0 ) {
            int ran = random.nextInt(2);
            setmoveXY(ran == 0 ? 2 : 1);
        }
        //0
        if ((x >= 619 && x <= 620) && (y >= 329 && y <= 330) ) {
            int ran = random.nextInt(3);
            switch (ran) {
                case 0 -> setmoveXY(3);
                case 1 -> setmoveXY(1);
                default -> setmoveXY(2);
            }
        }
        //0
        if ((x >= 619 && x <= 620) && (y >= 279 && y <= 280) ) {
            int ran = random.nextInt(2);
            setmoveXY(ran == 0 ? 2 : 0);
        }
        //0
        if ((x >= 619 && x <= 620) && (y >= 399 && y <= 400) ) {
            int ran = random.nextInt(2);
            setmoveXY(ran == 0 ? 3 : 0);
        }

        //2
        if ((x >= 679 && x <= 680) && (y >= 399 && y <= 400) ) {
            int ran = random.nextInt(3);
            switch (ran) {
                case 0 -> setmoveXY(0);
                case 1 -> setmoveXY(1);
                default -> setmoveXY(2);
            }
        }
        //2
        if ((x >= 754 && x <= 755) && (y >= 399 && y <= 400) ) {
            int ran = random.nextInt(2);
            setmoveXY(ran == 0 ? 3 : 1);
        }

        if ((x >= 754 && x <= 755) && (y >= 329 && y <= 330) ) {
            int ran = random.nextInt(3);
            switch (ran) {
                case 0 -> setmoveXY(0);
                case 1 -> setmoveXY(3);
                default -> setmoveXY(2);
            }
        }

        if ((x >= 754 && x <= 755) && (y >= 279 && y <= 280) ) {
            int ran = random.nextInt(2);
            setmoveXY(ran == 0 ? 2 : 1);
        }

        if ((x >= 679 && x <= 680) && (y >= 279 && y <= 280) ) {
            int ran = random.nextInt(3);
            switch (ran) {
                case 0 -> setmoveXY(0);
                case 1 -> setmoveXY(3);
                default -> setmoveXY(1);
            }
        }


    }

}
