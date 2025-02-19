package Character_component;

import AllMom.MomCharacter;

public class Snowkuy extends MomCharacter {
    public Snowkuy(int moveHow) {
        super(200, 200, 1300, 330, "snowkuy");
        super.startAnimation();
        super.startMove();
        super.setSpeed(5);
        setSize(30,53);
        super.setMoveHow(moveHow);

        setLayout(null);
        // JLabel l = new JLabel("LV.2");
        // l.setFont(new Font("Arial", Font.BOLD, 12));
        // l.setBounds(0, 0, 100, 50);
        // add(l);
    }
}
