package AllMom;

import Character_component.Move;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

public abstract class MomCharacter extends JPanel implements Move {
    private final ArrayList<Image> frames = new ArrayList<>();
    private int currentFrame = 0;
    private int move;
    private final String namePath;

    private float xOffset;
    private float yOffset;
    private float speed;
    private int moveXY;

    private int moveHow;
    private int step = 0;

    public MomCharacter(int width, int height, int x, int y, String namePath) {
        setOpaque(false);
        setSize(width, height);
        setLocation(x, y);
        this.namePath = namePath;
        this.xOffset = x;
        this.yOffset = y;
        this.moveXY = 0;
        this.speed = 2.5f;
        loadFrames();
    }

    protected void setMoveHow(int moveHow) {
        this.moveHow = moveHow;
    }

    public int getStep() {
        return this.step;
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
        for (int i = 1; i <= 9; i++) {
            try {
                Image img = ImageIO.read(new File("img/Character/" + namePath + "/Character" + i + ".png"));
                frames.add(img);
            } catch (IOException e) {
            }
        }
    }

    protected void startAnimation() {
        Timer timer = new Timer(100, _ -> {
            this.howMove();
            repaint();
        });
        timer.start();
    }

    protected void howMove() {
        if (this.move == 0) {
            currentFrame = (currentFrame == 0) ? 0 : 0;
        } else if (this.move == 1) {
            currentFrame = (currentFrame == 1) ? 2 : 1;
        } else if (this.move == 2) {
            currentFrame = (currentFrame == 3) ? 4 : 3;
        } else if (this.move == 3) {
            currentFrame = (currentFrame == 5) ? 6 : 5;
        } else {
            currentFrame = (currentFrame == 7) ? 8 : 7;
        }
    }

    @Override
    public void startMove() {
        Timer timer = new Timer(50, _ -> {
            switch (this.moveXY) {
                case 0 -> {
                    this.move = 1;
                    this.characterMoveR();
                }
                case 1 -> {
                    this.move = 2;
                    this.characterMoveL();
                }
                case 2 -> {
                    this.move = 3;
                    this.characterMoveD();
                }
                case 3 -> {
                    this.move = 0;// 4
                    this.characterMoveU();
                }
                default -> {
                    this.move = 0;
                }
            }
            moveRandom();
        });
        timer.start();
    }

    private void moveRandom() {
        Point location = getLocation();
        if (this.moveHow == 0) {
            this.moveHow_1(location);
        } else if (this.moveHow == 1) {
            this.moveHow_2(location);
        }
    }

    private void moveHow_1(Point location) {
        switch (step) {
            case 0 -> {
                if (location.x <= 750) {
                    setmoveXY(3);
                    step++;
                }
            }
            case 1 -> {
                if (location.y <= 280) {
                    setmoveXY(1);
                    step++;
                }
            }
            case 2 -> {
                if (location.x <= 620) {
                    setmoveXY(2);
                    step++;
                }
            }
            case 3 -> {
                if (location.y > 330) {
                    setmoveXY(1);
                    step++;
                }
            }
            case 4 -> {
                if (location.x <= 350) {
                    setmoveXY(3);
                    step++;
                }
            }
            case 5 -> {
                if (location.y <= 0) {
                    setmoveXY(1);
                    step++;
                }
            }
            case 6 -> {
                if (location.x <= 220) {
                    setmoveXY(2);
                    step++;
                }
            }
            case 7 -> {
                if (location.y >= 130) {
                    setmoveXY(0);
                    step++;
                }
            }
            case 8 -> {
                if (location.x >= 350) {
                    setmoveXY(2);
                    step++;
                }
            }
            case 9 -> {
                if (location.y >= 330) {
                    setmoveXY(1);
                    if (location.x <= 0) {
                        step = -1;
                    }
                }
            }
        }
    }

    private void moveHow_2(Point location) {
        switch (step) {
            case 0 -> {
                if (location.x <= 750) {
                    setmoveXY(3);
                    step++;
                }
            }
            case 1 -> {
                if (location.y <= 280) {
                    setmoveXY(1);
                    step++;
                }
            }
            case 2 -> {
                if (location.x <= 700) {
                    setmoveXY(3);
                    step++;
                }
            }
            case 3 -> {
                if (location.y <= 0) {
                    setmoveXY(0);
                    step++;
                }
            }
            case 4 -> {
                if (location.x >= 1300) {
                    setmoveXY(2);
                    step++;
                }
            }
            case 5 -> {
                if (location.y >= 330) {
                    setmoveXY(1);
                    step++;
                }
            }
            case 6 -> {
                if (location.x <= 750) {
                    setmoveXY(3);
                    step++;
                }
            }
            case 7 -> {
                if (location.y <= 280) {
                    setmoveXY(1);
                    step++;
                }
            }
            case 8 -> {
                if (location.x <= 620) {
                    setmoveXY(2);
                    step++;
                }
            }
            case 9 -> {
                if (location.y > 330) {
                    setmoveXY(1);
                    if (location.x <= 0) {
                        step = -1;
                    }
                }
            }
        }
    }
}
