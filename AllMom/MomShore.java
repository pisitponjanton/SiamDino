package AllMom;

import AllTread.StoreThread.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public abstract class MomShore extends JPanel{
    private String namePath;
    private ArrayList<Image> backgroundImage;
    private ProfitThread moneyThread;
    private int evo;
    private int level;
    private int money_profit;

    public MomShore(String namePath,int x,int y,int width,int height){
        this.namePath = namePath;
        setBounds(x, y, width, height);
        setOpaque(false);
        drawBackgroundImage();
    }

    public void startStore(){
        moneyThread = new ProfitThread(this);
        moneyThread.start();
    }

    public void stopStore(){
        moneyThread.interrupt();
    }

    public int getLevel(){
        return this.level;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public void setMoney_Profit(int money_profit){
        this.money_profit = money_profit;
    }

    public int getMoney_Profit(){
        return money_profit;
    }

    public int getProfit(){
        switch (level) {
            case 1 -> {
                return 40;
            }
            case 2 -> {
                return 60;
            }
            case 3 -> {
                return 80;
            }
            case 4 ->{
                return 100;
            }
            case 5 ->{
                return 130;
            }
            case 6 ->{
                return 170;
            }
            case 7 ->{
                return 210;
            }
            case 8 ->{
                return 260;
            }
            case 9 ->{
                return 320;
            }
            default -> {
                return 400;
            }
        }
    }


    public int getEvo(){
        return this.evo;
    }

    public void setEvo(int evo){
        this.evo = evo;
        repaint();
    }

    public int getTime(){
        switch (level) {
            case 1 -> {
                return 225000;
            }
            case 2 -> {
                return 210000;
            }
            case 3 -> {
                return 195000;
            }
            case 4 ->{
                return 180000;
            }
            case 5 ->{
                return 150000;
            }
            case 6 ->{
                return 120000;
            }
            case 7 ->{
                return 90000;
            }
            case 8 ->{
                return 60000;
            }
            case 9 ->{
                return 45000;
            }
            default -> {
                return 30000;
            }
        }
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
