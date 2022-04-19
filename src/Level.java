import Enums.Direction;
import Objects.*;
import Objects.Object;


/**
 * Represents a whole level.
 * A level is applicable to the runGameLoop() function
 * Use levels with the {@link Runtime#runGameLoop()} method in {@link Runtime}
 */
public class Level {
    /**
     * Field that holds the objects in the level.
     */
    Field field;
    /**
     * A player object used for the level.
     * Used in the {@link Level#move()} function.
     */
    Player player;
    /**
     * Name of Level, used in {@link Runtime#runGameLoop()}.
     */
    String name;
    /**
     * Boolean holding whether the level is finished or not.
     */
    boolean isCompleted = false;


    /**
     * Creates a new level.
     * @param name The name that the level is referred to in text.
     * @param field The field that will contain all of the levels objects.
     * @param playerX The starting x value of the player object.
     * @param playerY The starting y value of the player object.
     */
    public Level(String name, Field field, int playerX, int playerY) {
        this.field = field;
        this.player = new Player(playerX, playerY);
        this.name = name;
        field.placeObject(player);
    }


    /**
     * Returns the level's field object.
     * @return Level.field
     */
    public Field getField() {
        return field;
    }

    /**
     * A function which moves the player along the field.
     * Prints update lines, and also check for {out of bounds} errors.
     * @param direction The direction the player moves.
     */
    public void move(Direction direction) {
        int newX, newY, originalX, originalY;
        originalX = player.getX();
        originalY = player.getY();
        newX = originalX;
        newY = originalY;
        Air air = new Air(originalX, originalY);        
        switch (direction) {
            case UP:
            newY = originalY -= 1;
            break;
            case DOWN:
            newY = originalY += 1;
            break;
            case RIGHT:
            newX = originalX += 1;
            break;
            case LEFT:
            newX = originalX -= 1;
            break;
        }

        boolean isError = false;
        
        if (newX < getField().getLength() && newX > -1) {
            this.player.setX(newX);
            placeObject(air);
        } else {
            isError = true;
        }
        if (newY < getField().getHeight() && newY > -1) {
            this.player.setY(newY);
            placeObject(air);
        } else {
            isError = true;
        }
        if (!isError) {
            printMoveLine(direction);
        }
        else {
            printMoveErrorLine(direction);
            System.err.print("\n{Out of bounds error}");
        }
        placeObject(player);
        
    }

    public void printFormattedField() {
        field.printFormattedField();
    }

    public void printSizedBreakLine() {
        field.printSizedBreakLine();
    }

    public void placeObject(Object object) {
        field.placeObject(object);
    }

    public void complete() {
        isCompleted = true;
    }

    public String toString() {
        return name;
    }

    private static void printMoveLine(Direction direction) {
        System.out.print("Player moved ".concat(direction.toString().toLowerCase()).concat("."));
    }

    private static void printMoveErrorLine(Direction direction) {
        System.out.print("Player is unable to move ".concat(direction.toString().toLowerCase()).concat("."));
    }


}
