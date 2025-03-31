package Button_component;

import AllMom.*;
import java.awt.*;
import javax.swing.*;
public class Map_Button extends MomButton {
    private JLabel name,level,money;
    private ButtonDelete delete;
    public Map_Button(String name, int level,double  money) {
        super("mapButton", 1250, 200);
        this.name = new JLabel(name);
        this.level = new JLabel("Level:"+String.valueOf(level));
        this.money = new JLabel("Money:"+String.valueOf(money));
        this.delete = new ButtonDelete();
        setFont(FontLoader.loadFont(14f));
        setPreferredSize(new Dimension(1250, 200));
        setMaximumSize(new Dimension(1250, 200));
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        setLayout(null);
        this.delete.setLocation(1120, 154);
        this.name.setBounds(60, 8, 300, 100);
        this.name.setFont(FontLoader.loadFont(14f));
        this.level.setBounds(60, 53, 300, 100);
        this.level.setFont(FontLoader.loadFont(14f));
        this.money.setBounds(60, 95, 300, 100);
        this.money.setFont(FontLoader.loadFont(14f));
        add(this.name);
        add(this.level);
        add(this.money);
        add(this.delete);
    }

    public ButtonDelete getDelete(){
        return this.delete;
    }
    @Override
    public void startThread(){}
    @Override
    public void stopThread(){}
}
