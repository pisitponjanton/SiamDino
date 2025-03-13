package Background_component;

import AllMom.MomBackground;
import java.awt.*;
import javax.swing.*;

public class StatusBar extends MomBackground {
    private JLabel name,level,money,exp;
    public StatusBar(String name,int level,double money,int exp) {
        super("statusBar");
        setSize(294, 60);
        setLocation(0, 0);
        setLayout(null);

        this.name = new JLabel(name,JLabel.CENTER);
        this.level = new JLabel(level+"",JLabel.CENTER);
        this.money = new JLabel(money+"",JLabel.CENTER);
        this.exp = new JLabel(exp+"",JLabel.CENTER);

        this.name.setToolTipText("Name");
        this.name.setBounds(25, 0, 133, 30);
        this.name.setFont(new Font("Arial", Font.BOLD, 20));
        this.name.setForeground(Color.WHITE);


        this.level.setToolTipText("Level");
        this.level.setBounds(4, 0, 33, 32);
        this.level.setFont(new Font("Arial", Font.BOLD, 16));
        this.level.setForeground(Color.WHITE);

        add(this.name);
        add(this.level);

    }

    public void setStatusBar(String name,int level,double money,int exp){
        this.name.setText(name);
        this.level.setText(level+"");
        this.money.setText(money+"");
        this.exp.setText(exp+"");
    }

}
