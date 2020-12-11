import java.util.Scanner;

/**
 * @author Jaeren W. Tredway
 * @version 1.0 2019-09-06
 */
public class Pig {
    /**
     * This program plays a game where users take turns rolling dice, adding
     * the result to their total score. But after the first roll, a roll of one
     * ends that turn with zero points scored for that turn. First player to
     * 100 wins.
     *
     * @param args Command line arguments are ignored.
     */
    public static void main(String[] args) {
        // VARIABLES SECTION: ***********************
        int turn = 1;
        int numPlayers;
        Scanner scanner = new Scanner(System.in);
        boolean gameSession;
        int winningScore = 100;

        // GAME SETUP SECTION: **********************
        System.out.println("WELCOME TO THE PIG GAME!");
        numPlayers = 2;
        String[] players = new String[numPlayers];
        int[] scores = new int[numPlayers];

        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Player " + (i + 1) + ", enter your name: ");
            //scanner.hasNext();
            players[i] = scanner.nextLine();
        }

        System.out.print("Okay " + players[0]);
        for (int i = 1; i < numPlayers; i++) {
            System.out.print(" and " + players[i]);
        }
        System.out.println("...let's play the Pig Game!");

        //GAME PLAY SECTION: **************************
        do {
            while (scores[0] < winningScore && scores[1] < winningScore) {
                //START OF GAME TURN: **************************
                System.out.println("\nTURN " + turn);
                System.out.println("SCORE: " + players[0] + ": " + scores[0] +
                        " vs" + ". " + players[1] + ": " + scores[1]);
                for (int i = 0; i < 2; i++) {
                    //START OF ONE PLAYER'S TURN:**********
                    System.out.println();
                    boolean activeTurn;
                    int turnScore = 0;
                    do {
                        System.out.println(players[i].toUpperCase() + ", it " +
                                "is your turn: ");
                        int roll = (int) (Math.random() * 6) + 1;
                        System.out.println("You rolled a " + roll);
                        if (roll == 1) {
                            System.out.println(players[i] + ", you lost your" +
                                    "points for this turn!\n");
                            turnScore = 0;
                            activeTurn = false;
                        } else {
                            turnScore = turnScore + roll;
                            System.out.println("Okay, " + players[i] + ", " +
                                    "you have " + turnScore +
                                    " points so far for this turn.");
                            System.out.println("Roll again? ");
                            String answer = scanner.nextLine();
                            activeTurn = answer.equals("y");
                        }
                    } while (activeTurn);
                    scores[i] += turnScore;
                } //END OF ONE PLAYER'S TURN
                System.out.println();
                turn++;
            } //END OF GAME TURN

            //FINAL REPORT FOR GAME: ****************************
            System.out.println("FINAL SCORE:");
            System.out.println(players[0] + ": " + scores[0] + " vs. " +
                    players[1] + ": " + scores[1]);
            if (scores[0] >= winningScore && scores[1] >= winningScore) {
                System.out.println("\nCongratulations, " + players[0] + " " +
                        "and " + players[1] +
                        ", you both got " + winningScore + " or more, TIE " +
                        "GAME!");
            } else if (scores[0] >= winningScore) {
                System.out.println("\nCongratulations, " + players[0] + ", " +
                        "YOU WIN!");
            } else {
                System.out.println("\nCongratulations, " + players[1] + ", " +
                        "YOU WIN!");
            }

            // "PLAY AGAIN OR QUIT" SECTION:
            scores[0] = 0;
            scores[1] = 0;
            turn = 1;
            System.out.println("\nShall we play again? (y/n): ");
            String answer = scanner.nextLine();
            gameSession = answer.equals("y");

        } while (gameSession);
        System.out.println("Goodbye, thanks for playing the Pig Game!");
        // END OF GAME PLAY SECTION
    } // END OF main() METHOD
} // END OF Class Pig
