package Objects;

import java.util.ArrayList;

import Enums.State;


/**
 * The main object class, used in fields.
 * Contains many properties that all objects in fields share.
 * Mother class to many daughter classes.
 */
public class Object {
    int x, y;
    char symbol;
    State state;
    boolean controlled;
    ArrayList<Integer> coordinates = new ArrayList<Integer>();
    int id;

    public Object(int y, int x, char symbol, State state, boolean controlled) {
        this.y = y;
        this.x = x;
        this.symbol = symbol;
        this.state = state;
        this.controlled = controlled;


        // (y, x)
        /*
        |(0,0)|(0,1)|(0,2)|(0,3)|(0,4)|
        |(1,0)|(1,1)|(1,2)|(1,3)|(1,4)|
        |(2,0)|(2,1)|(2,2)|(2,3)|(2,4)|
        |(3,0)|(3,1)|(3,2)|(3,3)|(3,4)|
        |(4,0)|(4,1)|(4,2)|(4,3)|(4,4)|
        */
        coordinates.add(y);
        coordinates.add(x);
    } 

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getSymbol() {
        return symbol;
    }

    public State getState() {
        return state;
    }

    public boolean isControlled() {
        return controlled;
    }

    public ArrayList<Integer> getCoordinates() {
        return coordinates;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    } 

}
