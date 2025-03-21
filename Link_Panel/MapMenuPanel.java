package Link_Panel;

import AllMom.MomBackground;
import Background_component.NameText;
import Button_component.ButtonNew;
import Button_component.Map_Button;
import DataBase.*;
import java.awt.*;
import javax.swing.*;

public class MapMenuPanel extends MomBackground {
    private DataBase dataBase;
    private DataUser dataUser;
    private JScrollPane sp1;
    private JPanel jp1, jp2, mainPanel;
    private ButtonNew newButton;
    private CardLayout cardLayout;
    private GamePanel g;
    private int i_num;

    private NameText nameText;

    public MapMenuPanel(CardLayout cardLayout, JPanel mainPanel, GamePanel g) {
        super("bg");
        setLayout(null);
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        this.g = g;
        dataBase = new DataBase();
        dataUser = dataBase.getDataUser();

        jp2 = new JPanel();
        jp2.setLayout(null);
        jp2.setLocation(0, 685);
        jp2.setOpaque(false);
        jp2.setSize(1350, 200);

        nameText = new NameText();
        add(nameText);
        setComponentZOrder(nameText, 0);

        newButton = new ButtonNew();
        newButton.setLocation(620, 0);
        newButton.addActionListener(_ -> {
            if (nameText.isVisible()) {
                if (!nameText.getName().equals("")) {
                    dataUser.getDataUser().add(new DataMap(nameText.getName()));
                    System.out.println("AddDataMap");
                    loadMap();
                }
                nameText.setVisible(false);
                nameText.reName();
            } else {
                nameText.setVisible(true);
            }
        });
        jp2.add(newButton);

        jp1 = new JPanel();
        jp1.setLayout(new BoxLayout(jp1, BoxLayout.Y_AXIS));
        jp1.setOpaque(false);
        loadMap();

        sp1 = new JScrollPane(jp1, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sp1.setBounds(50, 150, 1250, 450);
        sp1.setOpaque(false);
        sp1.getViewport().setOpaque(false);
        sp1.setBorder(null);
        add(sp1);
        add(jp2);
    }

    public void loadMap() {
        i_num = 0;
        jp1.removeAll();
        for (DataMap m : dataUser.getDataUser()) {
            final int currentIndex = i_num;
            Map_Button b = new Map_Button(m.getName(), m.getLevel(), m.getMoney());
            b.addActionListener(_ -> {
                try {
                    g.start_Game(dataUser, currentIndex,this);
                    cardLayout.show(mainPanel, "GamePanel");
                    System.out.println("GameStart");
                } catch (Exception e) {
                    System.out.println(e);
                }
            });
            jp1.add(b);
            jp1.add(Box.createVerticalStrut(10));
            i_num++;
        }
    }
}
