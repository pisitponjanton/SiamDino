package Background_component;

import AllMom.Animation;
import AllMom.MomBackground;

public class NameGame extends MomBackground {
    public NameGame() {
        super("name");
        setSize(400, 400);
        setLocation(500, 50);
        new Animation(this,0);
    }
}
