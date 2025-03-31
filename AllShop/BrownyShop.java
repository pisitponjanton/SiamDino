package AllShop;

import AllMom.FontLoader;
import AllMom.MomButton;
import javax.swing.*;

public class BrownyShop extends MomButton implements ShopStatus {
    private int level;
    private int money;
    private JLabel moneyJLabel;
    private Thread thread;

    public BrownyShop() {
        super("AllShop/Browny/1", 184, 96);
        setLayout(null);
        reMoney();
        moneyJLabel = new JLabel(money + "");
        moneyJLabel.setBounds(130, 92, 80, 20);
        moneyJLabel.setFont(FontLoader.loadFont(12f));
        add(moneyJLabel);

    }

    @Override
    public void startThread() {
        thread = new Thread(() -> {
            try {
                while (true) {
                    if (level < 4) {
                        super.setNamePath("AllShop/Browny/1");
                    } else if (level >= 4 && level < 7) {
                        super.setNamePath("AllShop/Browny/2");
                    } else if (level >= 7) {
                        super.setNamePath("AllShop/Browny/3");
                    }
                    reMoney();
                    moneyJLabel.setText(money + "");
                    Thread.sleep(50);
                }
            } catch (InterruptedException e) {
            }
        });
        thread.start();
    }

    @Override
    public void stopThread() {
        thread.interrupt();
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return this.money;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }

    private void reMoney() {
        switch (level) {
            case 0 -> money = 1200;
            case 1 -> money = 1000;
            case 2 -> money = 1720;
            case 3 -> money = 2400;
            case 4 -> money = 3199;
            case 5 -> money = 4000;
            case 6 -> money = 5000;
            case 7 -> money = 7000;
            case 8 -> money = 10000;
            case 9 -> money = 20000;
            case 10 -> money = 40000;
            default -> money = 1200;
        }
    }

    @Override
    public String getStatus() {
        return "Level: " + level + ", Money: " + money;
    }
}
