package Background_component;

import AllMom.MomBackground;
import java.awt.*;
import javax.swing.*;

public class StatusBar extends MomBackground {
    private JLabel name,level,money,exp;

    public StatusBar() {
        super("statusBar");
        setSize(294, 60);
        setLocation(0, 0);
        setLayout(null);

        this.name = new JLabel("0",JLabel.CENTER);
        this.level = new JLabel("0",JLabel.CENTER);
        this.money = new JLabel("0",JLabel.CENTER);
        this.exp = new JLabel("0",JLabel.CENTER);

        this.name.setToolTipText("Name");
        this.name.setBounds(25, 0, 133, 30);
        this.name.setFont(new Font("Arial", Font.BOLD, 20));
        this.name.setForeground(Color.WHITE);


        this.level.setToolTipText("Level");
        this.level.setBounds(4, 0, 33, 32);
        this.level.setFont(new Font("Arial", Font.BOLD, 16));
        this.level.setForeground(Color.WHITE);

        this.money.setToolTipText("Money");
        this.money.setBounds(175, 0, 124, 36);
        this.money.setFont(new Font("Arial", Font.BOLD, 15));
        this.money.setForeground(Color.WHITE);

        this.exp.setToolTipText("Exp");
        this.exp.setBounds(0, 25, 300, 41);
        this.exp.setFont(new Font("Arial", Font.BOLD, 15));
        this.exp.setForeground(Color.WHITE);

        add(this.name);
        add(this.level);
        add(this.money);
        add(this.exp);
    }

    public void setStatusBar(String name,int level,double money,int exp){
        this.name.setText(name);
        this.level.setText(level+"");
        this.money.setText(money+"");
        this.exp.setText(exp+"");
    }

    public synchronized void setMoney(double money){
        this.money.setText(money+"");
    }

    @Override
    public void setName(String name){
        this.name.setText(name);
    }

    public void setLevel(int level){
        this.level.setText(level+"");
    }

    public void setExp(int exp){
        if(Integer.parseInt(level.getText()) < 30){
            this.exp.setText(exp+" / "+(Integer.parseInt(level.getText())*700));
        }
        else{
            this.exp.setText(exp+" / "+"999999999999");
        }
    }

}