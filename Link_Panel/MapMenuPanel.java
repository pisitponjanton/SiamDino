package Link_Panel;

import AllMom.MomBackground;
import Background_component.NameGame;
import Background_component.NameText;
import Button_component.ButtonBack;
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
    private int i_num,i;
    private ButtonBack buttonBack;

    private NameText nameText;
    private NameGame nameGame;

    public MapMenuPanel(CardLayout cardLayout, JPanel mainPanel, GamePanel g) {
        super("bgset/0");

        new Thread(()->{
            try {
                while (true) { 
                    Thread.sleep(300);
                    super.setNamePath("bgset/"+(i%10));
                    i++;
                }
            } catch (InterruptedException e) {
            }
        }).start();

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

        nameGame = new NameGame();
        
        buttonBack = new ButtonBack();
        buttonBack.setLocation(10,710);
        buttonBack.addActionListener(_->{
            cardLayout.show(mainPanel, "MenuPanel");
        });

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
        add(buttonBack);
        add(sp1);
        add(jp2);

        if(dataUser.getDataUser().isEmpty()){
            add(nameGame);
            setComponentZOrder(nameGame, 0);
        }
        

    }

    public void loadMap() {
        i_num = 0;
        remove(nameGame);
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
            b.getDelete().addActionListener(_->{
                dataUser.getDataUser().remove(currentIndex);
                loadMap();
                System.out.println("DeleteMap "+currentIndex);
            });
            jp1.add(b);
            jp1.add(Box.createVerticalStrut(10));
            i_num++;
        }
        repaint();
        DataBase.saveGame(dataUser);
    }
}
