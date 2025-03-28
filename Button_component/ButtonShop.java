package Button_component;

import AllMom.MomButton;
import java.awt.event.*;


public class ButtonShop extends MomButton implements MouseListener {
    public ButtonShop() {
        super("Allshop/buttonshop/1", 120, 72);
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
        super.setNamePath("Allshop/buttonshop/2");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        super.setNamePath("Allshop/buttonshop/1");
    }

    @Override
    public void startThread(){}
    @Override
    public void stopThread(){}
}
