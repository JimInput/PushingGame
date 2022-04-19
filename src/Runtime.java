import java.util.Scanner;
import static Enums.Direction.*;

/**
 * <h1>Pushing Game<h1>
 * There are multiple different levels to choose from!
 * The code is written "modularly" so that you can create more levels easily!
 * 
 * @author Jimmy Padilla
 * @version 0.1
 * @since 2022-18-04
 */

public class Runtime {
    
    /**
     * This is the main function that runs the main game loop.
     * @param args Unused.
     * @return Nothing.
     * @exception In the event of any Exception, program should cancel.
     * @see Exception
     */
    public static void main(String[] args) throws Exception {
        // Level testLevel = new Level("Fun", new Field(5, 5), 0, 0);

        runGameLoop(new Level("Fun", new Field(5, 5), 0, 0));
        // testLevel.printFormattedField();
    }


    /**
     * Runs a game loop for any level
     * @param level any defined level 
     */
    public static void runGameLoop(Level level) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Level: \"" + level.toString()  + "\"");
        while (!level.isCompleted) {
            level.printFormattedField();
            System.out.print("Next move: (LEFT, RIGHT, DOWN, UP)\n\nInput: ");
            String choice = input.nextLine();
            System.out.print("\n\n\n");
            switch (choice) {
                case "left", "a":
                level.move(LEFT);
                break;
                case "right", "d":
                level.move(RIGHT);
                break;
                case "down", "s":
                level.move(DOWN);
                break;
                case "up", "w":
                level.move(UP);
                break;
                case "win", "k":
                level.complete();
                break;
                default:
                System.err.print("Invalid input given.");
                break;
            }
        }
        System.out.println("Level: \"" + level.toString() + "\" completed");
        input.close();
    }
}
