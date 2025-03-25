package Character_component;

import AllMom.MomCharacter;

public class Fuy extends MomCharacter {
    public Fuy(int x,int y,int how) {
        super(30,54, x, y, "Fuy");
        setToolTipText("Fuy");
        super.setmoveXY(how);
        super.startMove();
    }
}
