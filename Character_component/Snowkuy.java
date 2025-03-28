package Character_component;

import AllMom.MomCharacter;

public class Snowkuy extends MomCharacter {
    public Snowkuy(int x,int y,int how) {
        super(30, 53, x, y, "snowkuy");
        setToolTipText("Snowkuy");
        super.setmoveXY(how);
        super.startMove();

        setLayout(null);
    }
}
