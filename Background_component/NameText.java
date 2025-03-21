package Background_component;

import AllMom.MomBackground;

import java.awt.GridLayout;

import javax.swing.JTextField;

public class NameText extends MomBackground{
    private JTextField name;
    public NameText(){
        super("text_name");
        name = new JTextField();
        setLayout(new GridLayout(1,1));
        add(name);
        setSize(200, 59);
        setLocation(575,620);
        setVisible(false);
    }

    public String getName(){
        return this.name.getText();
    }
    public void reName(){
        this.name.setText("");
    }
}
