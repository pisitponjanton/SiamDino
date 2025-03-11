package Button_component;

import AllMom.MomButton;
import java.awt.*;
import javax.swing.*;

public class Map_Button extends MomButton {
    private JLabel name;
    private JLabel level;
    private JLabel money;

    public Map_Button(String name, int level,double  money) {
        super("mapButton", 1250, 200);
        this.name = new JLabel(name);
        this.level = new JLabel(String.valueOf(level));
        this.money = new JLabel(String.valueOf(money));
        setFont(new Font("Arial", Font.BOLD, 24));
        setPreferredSize(new Dimension(1250, 200));
        setMaximumSize(new Dimension(1250, 200));
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        setLayout(null);
        this.name.setBounds(60, 5, 300, 100);
        this.name.setFont(new Font("Arial", Font.BOLD, 30));
        this.level.setBounds(200, 65, 300, 100);
        this.level.setFont(new Font("Arial", Font.BOLD, 20));
        this.money.setBounds(200, 107, 300, 100);
        this.money.setFont(new Font("Arial", Font.BOLD, 20));
        add(this.name);
        add(this.level);
        add(this.money);
    }
}
