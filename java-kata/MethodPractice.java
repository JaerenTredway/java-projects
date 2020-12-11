/**
 * CS152 Lab 4 -- Welcome to Methods.
 * Implement all the methods described below.
 *
 * @version 1.0
 * @author  Jaeren W. Tredway
 * lab section 006
 */
public class MethodPractice {

    /**
     * Returns largest of its arguments.
     *
     * @param x First integer argument
     * @param y Second integer argument
     * @param z Third integer argument
     * @return Maximum of x, y and z
     */
    private static int findLargest(int x, int y, int z) {
        int largest = Math.max(x, y);
        largest = Math.max(z, largest);
        return largest;
    }

    /**
     * Is the argument even?
     * (Recall that even numbers are divisible by 2)
     *
     * @param x Value to check.
     * @return True if x is an even number, false otherwise.
     */
    private static boolean isEven(int x) {
        return (x % 2 == 0);
    }

    /**
     * Does the given string contain the letter G (either upper or
     * lower case)?
     *
     * @param x String to check
     * @return True if x contains G, false otherwise.
     */
    private static boolean hasG(String x) {
        return x.toLowerCase().contains("g");
    }

    /**
     * Where is the location of the letter G (upper or lower case) in
     * the given string?
     *
     * @param x String to check
     * @return 0 based location of first occurrence of G in x,
     * -1 if G is not present.
     */
    private static int indexOfG(String x) {
        return x.toUpperCase().indexOf("G");
    }

    /**
     * This method returns a response based on the string input:
     * Apple => Orange
     * Hello => Goodbye!
     * Turing => Machine
     * Yay! => \o/
     * Any other input should be responded to with:
     * What should I say?
     *
     * @param input The input string
     * @return Corresponding output string.
     */
    private static String respond(String input) {
        return  (input.equals("Apple")) ? "Orange" :
                (input.equals("Hello")) ? "Goodbye!" :
                (input.equals("Turing")) ? "Machine" :
                (input.equals("Yay!")) ? "\\o/" : "What should I say?";
    }

    /**
     * Average up to five even numbers. Any odd values are
     * not included in the average.
     *
     * @param a First value
     * @param b Second value
     * @param c Third value
     * @param d Fourth value
     * @param e Fifth value
     * @return Average of the even input values. If none are even, returns
     *  -1000.
     */
    private static double averageOfEvensOnly(int a, int b, int c, int d,
                                             int e) {
        int[] list = {a, b, c, d, e};
        int sum = 0;
        int count = 0;
        for (int num : list) {
            if (num % 2 == 0) {
                sum += num;
                count++;
            }
        }
        return (count > 0) ? (double) sum / count : -1000;
    }


    // WRITE A METHOD FROM SCRATCH:

    /**
     * Method returns double of odd arg or square of even arg
     *
     * @param x integer value to be processed
     * @return integer result
     */
    private static int doubleOddSquareEven(int x) {
        return (x % 2 == 0) ? x * x : 2 * x;
    }


    // WRITE A METHOD FROM SCRATCH:

    /**
     * @param meal integer type with cost of meal
     * @param tip  double type with percentage of tip
     * @return double type with total cost of meal with tip
     */
    private static double computeMealTotal(int meal, double tip) {
        double tipCost = meal * tip;
        if (meal <= 0 || tip < 0 || tip > 0.7) {
            return -1;
        } else {
            return meal + tipCost;
        }
    }


    // This code tests your program's completeness.
    public static void main(String[] args) {
        System.out.println("\nThe following tests have passed: ");
        int numCorrect = 0;

        if (findLargest(1, 2, 3) == 3) {
            numCorrect++;
            System.out.println(1);
        }
        if (findLargest(4, -5, 2) == 4) {
            numCorrect++;
            System.out.println(2);
        }
        if (findLargest(0, 7, 5) == 7) {
            numCorrect++;
            System.out.println(3);
        }

        if (!isEven(3)) {
            numCorrect++;
            System.out.println(4);
        }
        if (isEven(-2)) {
            numCorrect++;
            System.out.println(5);
        }
        if (isEven(0)) {
            numCorrect++;
            System.out.println(6);
        }

        if (!hasG("man")) {
            numCorrect++;
            System.out.println(7);
        }
        if (hasG("dog")) {
            numCorrect++;
            System.out.println(8);
        }
        if (hasG("EGGSHELL")) {
            numCorrect++;
            System.out.println(9);
        }

        if (indexOfG("man") == -1) {
            numCorrect++;
            System.out.println(10);
        }
        if (indexOfG("EGGSHELL") == 1) {
            numCorrect++;
            System.out.println(11);
        }
        if (indexOfG("dog") == 2) {
            numCorrect++;
            System.out.println(12);
        }
        if (indexOfG("xyzggGGggG") == 3) {
            numCorrect++;
            System.out.println(13);
        }
        if (indexOfG("xyzGGggGGg") == 3) {
            numCorrect++;
            System.out.println(14);
        }

        if (respond("Apple").equals("Orange")) {
            numCorrect++;
            System.out.println(15);
        }
        if (respond("Hello").equals("Goodbye!")) {
            numCorrect++;
            System.out.println(16);
        }
        if (respond("Turing").equals("Machine")) {
            numCorrect++;
            System.out.println(17);
        }
        if (respond("Yay!").equals("\\o/")) {
            numCorrect++;
            System.out.println(18);
        }
        if (respond("xyz").equals("What should I say?")) {
            numCorrect++;
            System.out.println(19);
        }

        if (averageOfEvensOnly(12, 13, 12, 13, 12) == 12.0) {
            numCorrect++;
            System.out.println(20);
        }
        if (averageOfEvensOnly(-1, 3, -5, 7, 9) == -1000.0) {
            numCorrect++;
            System.out.println(21);
        }
        if (averageOfEvensOnly(0, 0, 15, 0, -2) == -0.5) {
            numCorrect++;
            System.out.println(22);
        }
        if (averageOfEvensOnly(100, -3, 4021, -2, 13) == 49.0) {
            numCorrect++;
            System.out.println(23);
        }

        if (doubleOddSquareEven(4) == 16) {
            numCorrect++;
            System.out.println(24);
        }
        if (doubleOddSquareEven(3) == 6) {
            numCorrect++;
            System.out.println(25);
        }

        if (computeMealTotal(0, .3) == -1) {
            numCorrect++;
            System.out.println(26);
        }
        if (computeMealTotal(10, .2) == 12.0) {
            numCorrect++;
            System.out.println(27);
        }
        if (computeMealTotal(100, .5) == 150) {
            numCorrect++;
            System.out.println(28);
        }
        if (computeMealTotal(100, .71) == -1) {
            numCorrect++;
            System.out.println(29);
        }
        if (computeMealTotal(120, .32) == 158.4) {
            numCorrect++;
            System.out.println(30);
        }

        System.out.println("Your program's completeness is currently: " +
                numCorrect + "/30");
    }
}
