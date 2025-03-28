package Button_component;

import AllMom.MomButton;
import java.awt.event.*;


public class ButtonMenu extends MomButton implements MouseListener {
    public ButtonMenu() {
        super("Allshop/MenuButton/1", 126, 49);
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {}
    
    @Override
    public void mouseEntered(MouseEvent e) {
        super.setNamePath("Allshop/MenuButton/2");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        super.setNamePath("Allshop/MenuButton/1");
    }
    @Override
    public void startThread(){}
    @Override
    public void stopThread(){}
}
