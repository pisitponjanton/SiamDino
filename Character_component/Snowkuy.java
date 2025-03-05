package Character_component;

import AllMom.MomCharacter;

public class Snowkuy extends MomCharacter {
    public Snowkuy(int x,int y,int how) {
        super(30, 53, x, y, "snowkuy");
        super.setmoveXY(how);
        super.startMove();

        setLayout(null);
        // JLabel l = new JLabel("LV.2");
        // l.setFont(new Font("Arial", Font.BOLD, 12));
        // l.setBounds(0, 0, 100, 50);
        // add(l);
    }
}
