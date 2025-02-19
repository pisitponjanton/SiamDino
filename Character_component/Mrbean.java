package Character_component;

import AllMom.MomCharacter;

public class Mrbean extends MomCharacter {
    public Mrbean(int moveHow) {
        super(45, 75, 1350, 330, "mrbean");
        super.setSpeed(10);
        super.startAnimation();
        super.startMove();
        super.setMoveHow(moveHow);
        setSize(30, 60);
        // setmoveXY();

        setLayout(null);
        // JLabel l = new JLabel("LV.1");
        // l.setFont(new Font("Arial", Font.BOLD, 12));
        // l.setBounds(85, 10, 100, 50);
        // add(l);
    }
}
