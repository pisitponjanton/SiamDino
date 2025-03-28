package Button_component;

import AllMom.MomButton;
import java.awt.*;
import javax.swing.*;

public class Map_Button extends MomButton {
    private JLabel name,level,money;
    private ButtonDelete delete;

    public Map_Button(String name, int level,double  money) {
        super("mapButton", 1250, 200);
        this.name = new JLabel(name);
        this.level = new JLabel("Level : "+String.valueOf(level));
        this.money = new JLabel("Money : "+String.valueOf(money));
        this.delete = new ButtonDelete();
        setFont(new Font("Arial", Font.BOLD, 24));
        setPreferredSize(new Dimension(1250, 200));
        setMaximumSize(new Dimension(1250, 200));
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        setLayout(null);
        this.delete.setLocation(1120, 154);
        this.name.setBounds(60, 8, 300, 100);
        this.name.setFont(new Font("Arial", Font.BOLD, 30));
        this.level.setBounds(60, 53, 300, 100);
        this.level.setFont(new Font("Arial", Font.BOLD, 20));
        this.money.setBounds(60, 95, 300, 100);
        this.money.setFont(new Font("Arial", Font.BOLD, 20));
        add(this.name);
        add(this.level);
        add(this.money);
        add(this.delete);
    }

    public ButtonDelete getDelete(){
        return this.delete;
    }
}
