package Button_component;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class Map_Button extends JButton {
    private JLabel text;

    public Map_Button(String name, int level,double  money) {
        text = new JLabel("Level : "+level+" Money : "+money+" THB");
        setText(name);
        setFont(new Font("Arial", Font.BOLD, 24));
        setPreferredSize(new Dimension(1250, 200));
        setMaximumSize(new Dimension(1250, 200));
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        setLayout(new BorderLayout());
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setBorder(new EmptyBorder(0, 0, 10, 0));
        add(text, BorderLayout.SOUTH);
    }
}
