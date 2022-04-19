package Objects;

import static Enums.State.*;
import Enums.Direction;

public class Player extends Object {

    Direction lastDir;
    
    public Player(int startingX, int startingY) {
        super(startingY, startingX, 'p', TANGIBLE, true);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
