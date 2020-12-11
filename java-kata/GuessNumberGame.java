import java.util.Scanner;

/**
 * @version 2.0 2019-08-28
 * @author Jaeren Tredway
 */

public class Main {
    /**
     * This program plays a game with the user by randomly generating a number from 1 to 10 and making
     *      the user try to guess it.
     * @param args Command line arguments are ignored.
     */
    public static String userName;
	public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        createUser();
    } //End of main() ********************************************


    public static void createUser() {
        System.out.println("\nGreetings humanoid lifeform, welcome to the GuessNumber Game.");
        System.out.print("\nPlease enter your name: ");
        userName = scanner.nextLine();
        System.out.println("Hello " + userName + ", would you like to play a game? (y/n)");
        String answer = scanner.nextLine();
		if (answer.equals("y")) {
			playGame();
		} else {
			System.out.println("Ok fine.");
		}
    } //End of createUser() ***************************************


    public static void playGame() {
        System.out.println("OK, " + userName + ", prepare to compete against your superior \nand most likely lose badly.\n");
        System.out.print(userName + ", please enter a number between one and ten: ");
       	int guess = scanner.nextInt();
		int randomNum = (int)(Math.random() * 10) + 1;
		System.out.println("You have guessed " + guess);
		System.out.println("Whilst I generated " + randomNum);

		if (guess == randomNum) {
			System.out.println("\nIncredible, " + userName + ", you have won!");
		} else {
			System.out.println("\nBehold, " + userName + ", you have lost!");
		}

		System.out.println("\nPlay again? (y/n)");
		scanner.nextLine(); //consume the \n not consumed by the previous nextInt()
		String answer = scanner.nextLine();
		
		if (answer.equals("y")) {
			playGame();
		} else {
			System.out.println("Darn.");
		}

    } // End of playGame() ***************************************
} // End of class GuessNumber
