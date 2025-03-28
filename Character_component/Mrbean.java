package Character_component;

import AllMom.MomCharacter;

public class Mrbean extends MomCharacter {
    public Mrbean(int x,int y,int how) {
        super(30, 60, x, y, "mrbean");
        setToolTipText("Mrbean");
        super.setmoveXY(how);
        super.startMove();

        setLayout(null);
    }
}
