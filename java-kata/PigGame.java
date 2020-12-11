import java.util.Scanner;

public class PigGame {

    public static final int NUM_TO_WIN = 10;

    private PigPlayer[] players;
    private Scanner sc = new Scanner(System.in);

    public PigGame(int numPlayers) {
        players = new PigPlayer[numPlayers];

        for(int i = 0; i < numPlayers; ++i) {
            System.out.println("Player " + (i + 1) + ", what is your name?");
            String name = sc.nextLine();
            players[i] = new PigPlayer(name);
        }
    }

    public String toString() {
        String result = "";
        for(PigPlayer p : players) {
            result += p.toString() + "\n";
        }
        return result;
    }

    private boolean hasWinner() {
        for(PigPlayer p : players) {
            if(p.getScore() >= NUM_TO_WIN) {
                return true;
            }
        }
        return false;
    }

    public void playGame() {
        int playerIndex = 0;

        while(!hasWinner()) {
            PigPlayer p = players[playerIndex];
            System.out.println(p.getName() + ", it is your turn");
            p.takeTurn(sc);

            playerIndex = (playerIndex + 1) % players.length;
        }

        System.out.println("Game over!");
        System.out.println(this);
    }

    public static void main(String[] args) {
        PigGame game = new PigGame(3);
        System.out.println(game);
        game.playGame();
    }
}
