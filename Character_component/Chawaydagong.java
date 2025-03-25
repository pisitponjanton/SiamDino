package Character_component;

import AllMom.MomCharacter;

public class Chawaydagong extends MomCharacter {
    public Chawaydagong(int x,int y,int how) {
        super(30,60, x, y, "Chawaydagong");
        setToolTipText("Chawaydagong");
        super.setmoveXY(how);
        super.startMove();
    }
}
