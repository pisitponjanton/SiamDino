package AllMom;

import java.awt.*;
import javax.swing.*;

public abstract class MomBackground extends JPanel {
    private Image backgroundImage;
    private String namePath;

    public MomBackground(String namePath) {
        this.namePath = namePath;
        this.drawBackgroundImage();
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

    private void drawBackgroundImage() {
        backgroundImage = new ImageIcon("img/backgroundImage/" + this.namePath + ".jpg").getImage();
    }
}
