import java.util.Scanner;

public class PigPlayer {

    public static final int DIE_SIZE = 6;

    private String name;
    private int score = 0;

    public PigPlayer(String name) {
        this.name = name;
    }

    public String toString() {
        return name + " " + score;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public void takeTurn(Scanner sc) {
        int turnScore = 0;
        boolean keepPlaying = true;
        while(keepPlaying) {
            int dieRoll = (int)(Math.random()*DIE_SIZE) + 1;
            System.out.println("You rolled a " + dieRoll);
            if(dieRoll == 1) {
                System.out.println("Sorry, turn over!");
                keepPlaying = false;
                turnScore = 0;
            } else {
                turnScore += dieRoll;
                System.out.println("Score for this turn is " + turnScore);
                System.out.println("Keep rolling? (y/n)");
                String response = sc.nextLine().trim().toLowerCase();
                keepPlaying = response.startsWith("y");
            }
        }
        score += turnScore;
        System.out.println("Your score is " + score);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        PigPlayer p = new PigPlayer("Jose");
        System.out.println(p);

        p.takeTurn(in);
        System.out.println(p);
    }
}
