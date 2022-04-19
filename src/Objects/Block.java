package Objects;

import static Enums.State.*;
public class Block extends Object{
    
    public Block(int x, int y) {
        super(y, x, 'b', PUSHABLE, false);
    }
}
