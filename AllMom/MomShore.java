package AllMom;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public abstract class MomShore extends JPanel{
    private String namePath;
    private ArrayList<Image> backgroundImage;
    private int evo;
    private int level;
    private int profit;

    public MomShore(String namePath,int x,int y,int width,int height){
        this.namePath = namePath;
        setBounds(x, y, width, height);
        setOpaque(false);
        drawBackgroundImage();
    }

    public int getLevel(){
        return this.level;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public int getProfit(){
        return this.profit;
    }

    public void setProfit(int profit){
        this.profit = profit;
    }

    public int getEvo(){
        return this.evo;
    }

    public void setEvo(int evo){
        this.evo = evo;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!backgroundImage.isEmpty()) {
            g.drawImage(backgroundImage.get(evo), 0, 0, getWidth(), getHeight(), this);
        }
    }

    private void drawBackgroundImage() {
        backgroundImage = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            try {
                Image img = ImageIO.read(new File("img/backgroundImage/StoreImage/" + this.namePath+"/"+ i + ".png"));
                backgroundImage.add(img);
            } catch (IOException e) {
            }
        }
    }
}
