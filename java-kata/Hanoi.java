import java.util.Scanner;

/**
 * This class runs a recursion that solves a Tower of Hanoi puzzle with
 * 3 poles and how ever many discs you choose
 * @author Jaeren W. Tredway
 * @version 1.0
 */
class Hanoi {

    public static void main (String[] args) {
        int numDiscs = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to my Tower of Hanoi algorithm.");
        System.out.println("Enter the number of discs you are using: ");
        numDiscs = scanner.nextInt();
        System.out.println("DO THESE MOVES TO SOLVE PUZZLE:");

        hanoi(numDiscs, 1, 3, 2);
    }//End of main()

    /**
     * @param nDiscs    :the number of discs your puzzle uses
     * @param moveFrom  :the pole you are currently starting from
     * @param toTarget  :the pole you want your current stack to end up on
     * @param toHelper  :the intermediate pole you are using to get pieces
     *                  out of the way
     */
    public static void hanoi (int nDiscs, int moveFrom, int toTarget, int toHelper) {

        if (nDiscs == 1) {
            move (moveFrom, toTarget);
        } else {
            hanoi (nDiscs - 1, moveFrom, toHelper, toTarget);
            move (moveFrom , toTarget);
            hanoi (nDiscs - 1, toHelper, toTarget, moveFrom);
        }
    }//End of hanoi()

    /**
     * This method prints out the next move you need to do.
     * @param moveFrom :move disc from here
     * @param toTarget :to here
     */
    public static void move (int moveFrom, int toTarget) {
        System.out.println (moveFrom + " -> " + toTarget);
    }//End of move()

}//End of Hanoi class
