import java.util.Scanner;

/**
 * @author Jaeren W Tredway
 * @version 1.0 for CS261 Spring 2020
 *
 * This implements the extended Euclid's Algorithm to get gcd(a, b) and the
 * linear combination gcd(a, b) = sa + tb as in Bezout's Identity
 *
 * scanner user input: two positive integers a and b
 * output: from the Euclidian Algorithm --> gcd(a, b)
 * output: as per Bezout's Identity --> gcd(a, b) = sa + tb
 *
 * to compile in command line: javac EuclidsAlgorithm.java
 *
 * to run program: java EuclidsAlgorithm
 */
public class EuclidsAlgorithm {

    //CLASS VARIABLES:
    private static Scanner scanner = new Scanner(System.in);
    private static int a = 0; //first user-input number
    private static int b = 0; //second user-input number
    private static int s = 0; //the Bezout's coefficient to a
    private static int t = 0; //the Bezout's coefficient to b
    private static int d = 0; //the value of gcd(a , b)


    //get user input for a and b:
    private static void getInput() {
        System.out.println("Enter the positive integer for \"a\": ");
        a = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the positive integer for \"b\": ");
        b = scanner.nextInt();
        scanner.nextLine();
    }//END method getInput()................................................


    //build an array to store [d, s, t] for each recursion step:
    //(d = gcd(a, b) = sa + tb) :
    private static int[] gcd(int a, int b) {
    //exit condition:
        if (b == 0) {
            return new int[] { a, 1, 0 };
        }
    //run another recursion until you get to the exit condition:
        int[] store = gcd(b, a % b);
    //assign the values from each recursion step to the class variables as
    //    you unwind the recursion:
        d = store[0];
        s = store[2];
        t = store[1] - (a / b) * store[2];
        return new int[] { d, s, t };
    }//END method gcd().....................................................


    //there are no command line args:
    public static void main(String[] args) {
    //get the user input:
        getInput();
    //run the algorithm:
        gcd(a, b);
    //print the output:
        System.out.println("Greatest Common Denominator from Euclidian " +
                "Algorithm:");
        System.out.println("gcd(" + a + ", " + b + ") = " + d);
        System.out.println("Linear Combination as in Bezout's Identity:");
        System.out.println("s(a) + t(b) = gcd(a, b)");
        System.out.println(s + "(" + a + ") + " + t +
                "(" + b + ") = " + d);
    }//END main()..........................................................
}//END class EuclidsAlgorithm
