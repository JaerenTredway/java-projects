// The import statement tells Java that we'll be using the Scanner class.
// Eclipse will offer to put an import line in for you when you use another class.
import java.util.Scanner;

/**
 * A small program to demonstrate how to read values typed by the user.
 * Excessively commented to explain what is going on.
 */
public class ScannerDemo {

    // static final variables are called constants and don't change value
    // We use constants to give names to "magic numbers", messages, etc.
    public static final int DRINKING_AGE = 21;

    /**
     * Program prompts the user for name and age and uses the values.
     */
    public static void main(String[] args) {

        // This line creates a Scanner object to read from the console.
        Scanner scanIn = new Scanner(System.in);

        // Prompt the user for a name
        System.out.println("What is your name?");
        
        // Read a line of user input and store it in a variable.
        String name = scanIn.nextLine();
        
        System.out.println("What is your age?");

        // Read an integer value from user input and store in variable.
        // Scanner class can convert text into numbers for you
        // If user doesn't type an int, there will be an error here.
        int age = scanIn.nextInt();

        // Let's greet the user by name.
        // We can use the + operator to concatenate Strings
        System.out.println("Hello, " + name + ".");

        // if/else lets us choose branches
        if(age < DRINKING_AGE) {
            System.out.println("You are too young to go drinking.");
        } else {
            System.out.println("You are allowed to buy alcohol.");
        }

        // Using a String method to get length of name
        System.out.println("Your name has " + name.length() + " characters.");

        // Using a Math method to compute square root
        System.out.println("The square root of your age is " + Math.sqrt(age));

        // Selecting a random number.
        // The Math.random method gives a double in the range [0.0, 1.0)
        System.out.println("A random number is: " + Math.random());

        // Pretend we are rolling a 6 sided die.
        int dieRoll = (int)(Math.random()*6) + 1;
        System.out.println("A random die roll = " + dieRoll);
    }
}