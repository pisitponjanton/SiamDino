package Character_component;

import AllMom.MomCharacter;

public class Bank extends MomCharacter{
    public Bank(int moveHow){
        super(30, 60, 1350, 330, "bank");
        super.startAnimation();
        super.startMove();
        super.setMoveHow(moveHow);
    }
}
