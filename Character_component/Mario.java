package Character_component;

import AllMom.MomCharacter;

public class Mario extends MomCharacter {
    public Mario(int x,int y,int how) {
        super(30,53, x, y, "mario");
        super.setmoveXY(how);
        super.startMove();
    }
}
