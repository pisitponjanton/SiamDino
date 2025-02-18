package Button_component;

import AllMom.MomButton;
import java.awt.event.*;
import javax.swing.event.*;

public class Start extends MomButton {
    public Start() {
        super("Start", 196, 68);
        setLocation(600, 400);
        addMouseListener(new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setNamePath("Start2");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setNamePath("Start");
            }

            @Override
            public void mouseDragged(MouseEvent e) {
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });
    }
}
