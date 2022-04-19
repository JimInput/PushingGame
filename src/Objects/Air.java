package Objects;
import static Enums.State.*;

public class Air extends Object{
    
    public Air (int x, int y) {
        super(y, x, ' ', NONTANGIBLE, false);
    }
}
