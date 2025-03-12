package Character_component;

import AllMom.MomCharacter;

public class Bank extends MomCharacter{
    public Bank(int x,int y,int how){
        super(30, 60, x, y, "bank");
        setToolTipText("Bank");
        super.setmoveXY(how);
        super.startMove();
    }
}
