package Link_Panel;

import AllMom.MomBackground;
import DataBase.*;
import java.awt.*;
import javax.swing.*;

public class MapMenuPanel extends MomBackground{
    private DataBase dataBase;
    public MapMenuPanel(CardLayout cardLayout, JPanel mainPanel,GamePanel g){
        super("bg");
        JButton b = new JButton("Next");
        b.setVisible(false);
        JButton new_Button = new JButton("New");
        dataBase = new DataBase();
        DataUser dataUser = dataBase.getDataUser();
        b.addActionListener(_->{
            g.start_Game(dataUser);
            cardLayout.show(mainPanel, "GamePanel");
            System.out.println("GameStart");
        });
        new_Button.addActionListener(_->{
            dataUser.getDataUser().add(new DataMap("top"));
            System.out.println("AddDataMap");
            b.setVisible(true);
        });
        add(b);
        add(new_Button);
    }
}
