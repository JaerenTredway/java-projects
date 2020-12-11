import java.util.Scanner;

public class QuestionsGame {

    public static boolean query(String question, Scanner sc) {
        System.out.println(question + " [Y/N]");
        String s = sc.nextLine();
        return s.toUpperCase().charAt(0) == 'Y';
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = new Node("cat");
        
        while(query("Want to play?", sc)) {
            Node currNode = root;
            
            while(!currNode.isLeaf()) {
                if(query(currNode.getData(), sc)) {
                    currNode = currNode.getLeft();
                } else {
                    currNode = currNode.getRight();
                }
            }

            if(query("Is it " + currNode.getData() + "?", sc)) {
                System.out.println("I knew it!");
            } else {
                System.out.println("What were you thinking?");
                String userAnswer = sc.nextLine();
                String compGuess = currNode.getData();
                System.out.println("Give question that is yes for " +
                        userAnswer + ", no for " + compGuess);
                String question = sc.nextLine();
                Node yesNode = new Node(userAnswer);
                Node noNode = new Node(compGuess);
                currNode.updateValues(question, yesNode, noNode);                    
            }
        }
        
        root = null;
    }

}
