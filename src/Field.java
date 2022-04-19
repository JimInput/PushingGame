import java.util.ArrayList;

import Objects.Air;
import Objects.Object;

/**
 * Represents a level's field.
 * A 2D array which has two properties, length and height.
 * Holds objects, a mother class.
 */
public class Field {
    private ArrayList<ArrayList<Object>> field = new ArrayList<ArrayList<Object>>();
    private int length, height;

    public Field(int length, int height) {
        this.length = length;
        this.height = height;

        for (int i = 0; i < height; i++) {
            field.add(i, new ArrayList<Object>());
            for (int j = 0; j < length; j++) {
                field.get(i).add(new Air(i, j));
            }
        }
    }

    public ArrayList<ArrayList<Object>> getFieldArray() {
        return field;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    // Goal:
    /*
    +---+---+---+---+---+
    | i | i | i | i | i |
    +---+---+---+---+---+
    | i | i | i | i | i |
    +---+---+---+---+---+
    | i | i | i | i | i |
    +---+---+---+---+---+
    | i | i | i | i | i |
    +---+---+---+---+---+
    | i | i | i | i | i |
    +---+---+---+---+---+
    */

    public void placeObject(Object object) {
        int x = object.getX();
        int y = object.getY();
        // System.out.println(field.toString());
        field.get(y).set(x, object);
        // System.out.println(field.toString());
    }

    // public void updateField() {
        
    // }

    // public void updateObject(Object object) {
    //     for(int i =0; i < height; i++) {
    //         int index = getField().get(i).indexOf(object);
    //         if (index != -1) {
    //             field.get(i).set(index, new Air(i, index));
    //             placeObject(object);
    //         }
    //     }
    // }

    public void printFormattedField() {
        printSizedBreakLine();
        for (int i = 0; i < getHeight(); i++) {
            System.out.print("|");
            for (int j = 0; j < getLength(); j++) {
                System.out.print(" " + getFieldArray().get(i).get(j).getSymbol() + " |");
            }
            printSizedBreakLine();
        }
    }

    public void printSizedBreakLine() {
        System.out.print("\n+");
        for (int i = 0; i < getLength(); i++) {
            System.out.print("---+");
        }
        System.out.print("\n");
    }

}
