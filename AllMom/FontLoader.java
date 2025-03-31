package AllMom;
import java.awt.*;
import java.io.*;

public class FontLoader {
    public static Font loadFont(float size) {
        try {
            File fontFile = new File("fonts/PressStart2P-Regular.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
            return font.deriveFont(size);
        } catch (IOException | FontFormatException e) {
            return new Font("Serif", Font.BOLD, (int) size);
        }
    }
}
