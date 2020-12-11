import java.util.Scanner;

public class TestRPS {

    public static RockPaperScissors pickRandom() {
        RockPaperScissors[] allChoices = RockPaperScissors.values();
        int randNum = (int)(Math.random()*allChoices.length);
        return allChoices[randNum];
    }
    
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in); 
       System.out.println("Play to how many wins?");
       int target = sc.nextInt();
       if(sc.hasNextLine()) {
           sc.nextLine(); // discard newline
       }
       
       int humanWins = 0;
       int compWins = 0;
       
       while(humanWins < target && compWins < target) {
           System.out.println("Rock, paper, or scissors?");
           String s = sc.nextLine();
           
           RockPaperScissors rps = RockPaperScissors.valueOf(s.toUpperCase());
    
           System.out.println("Human picked " + rps.toPrettyString());
           
           RockPaperScissors compChoice = pickRandom();
           System.out.println("Computer picked " + compChoice.toPrettyString());
           if(rps.equals(compChoice)) {
               System.out.println("It's a tie!");
           } else if(rps.winsAgainst(compChoice)) {
               System.out.println("Human wins!");
               humanWins++;
           } else {
               System.out.println("Computer wins!");
               compWins++;
           }
               
       }
       if(humanWins > compWins) {
           System.out.println("Human wins the match");
       } else {
           System.out.println("Computer wins the match");
       }
    }

}
