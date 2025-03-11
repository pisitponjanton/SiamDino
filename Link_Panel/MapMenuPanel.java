package Link_Panel;

import AllMom.MomBackground;
import Button_component.Map_Button;
import DataBase.*;
import java.awt.*;
import javax.swing.*;

public class MapMenuPanel extends MomBackground {
    private DataBase dataBase;
    private DataUser dataUser;
    private JScrollPane sp1;
    private JPanel jp1, jp2, mainPanel;
    private JButton newButton;
    private CardLayout cardLayout;
    private GamePanel g;
    private JTextField tfName;
    private int i_num;

    public MapMenuPanel(CardLayout cardLayout, JPanel mainPanel, GamePanel g) {
        super("bg");
        setLayout(null);
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        this.g = g;
        dataBase = new DataBase();
        dataUser = dataBase.getDataUser();
        tfName = new JTextField();
        tfName.setSize(200, 30);
        tfName.setLocation(575,670);
        tfName.setVisible(false);

        jp2 = new JPanel();
        jp2.setLocation(0, 700);
        jp2.setOpaque(false);
        jp2.setSize(1350, 200);
        newButton = new JButton("NEW");
        newButton.setPreferredSize(new Dimension(100, 50));
        newButton.addActionListener(_ -> {
            tfName.setVisible(true);
            if(!tfName.getText().equals("")){
                dataUser.getDataUser().add(new DataMap(tfName.getText()));
                System.out.println("AddDataMap");
                loadMap();
                tfName.setText("");
                tfName.setVisible(false);
            }
        });
        jp2.add(newButton);

        jp1 = new JPanel();
        jp1.setLayout(new BoxLayout(jp1, BoxLayout.Y_AXIS));
        loadMap();

        sp1 = new JScrollPane(jp1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sp1.setBounds(50, 150, 1250, 400);
        add(sp1);
        add(jp2);
        add(tfName);
        setComponentZOrder(tfName, 0);

    }

    private void loadMap() {
        i_num = 0;
        jp1.removeAll();
        for (DataMap m : dataUser.getDataUser()) {
            final int currentIndex = i_num;
            Map_Button b = new Map_Button(m.getName(), m.getLevel(), m.getMoney());
            b.addActionListener(_ -> {
                try {
                    g.start_Game(dataUser,currentIndex);
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
