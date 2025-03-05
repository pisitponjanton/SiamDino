package Character_component;

import AllMom.MomCharacter;

public class Mrbean extends MomCharacter {
    public Mrbean(int x,int y,int how) {
        super(30, 60, x, y, "mrbean");
        super.setmoveXY(how);
        super.startMove();

        setLayout(null);
        // JLabel l = new JLabel("LV.1");
        // l.setFont(new Font("Arial", Font.BOLD, 12));
        // l.setBounds(85, 10, 100, 50);
        // add(l);
    }
}
