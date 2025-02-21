package AllMom;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

public abstract class MomAnimalCage extends JPanel {
    private ArrayList<Image> backgroundImage = new ArrayList<>();
    private String namePath;
    private int level;

    public MomAnimalCage(String namePath) {
        this.namePath = namePath;
        this.drawBackgroundImage();
        setOpaque(false);
    }

    public int getLevel(){
        return this.level;
    }

    public void setLevel(int lv){
        this.level = lv;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!backgroundImage.isEmpty()) {
            g.drawImage(backgroundImage.get(level), 0, 0, getWidth(), getHeight(), this);
        }
    }

    private void drawBackgroundImage() {
        for (int i = 1; i <= 3; i++) {
            try {
                Image img = ImageIO.read(new File("img/backgroundImage/AnimalCage/" + this.namePath+"/"+ i + ".png"));
                backgroundImage.add(img);
            } catch (IOException e) {
            }
        }
    }
}
