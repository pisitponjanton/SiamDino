package Button_component;

import AllMom.MomButton;
import java.awt.event.*;

public class ButtonNew extends MomButton implements MouseListener {
    public ButtonNew() {
        super("Allshop/NewButton/1", 134, 80);
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
        super.setNamePath("Allshop/NewButton/2");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        super.setNamePath("Allshop/NewButton/1");
    }
}
