import java.util.ArrayList;

// a TransitionRule is a list of any NGrams that come after their key NGram
// somewhere in the text
public class TransitionRule {

    // Each NGram in a TransitionRule list has appeared right after its
    // paired key NGram somewhere in the text file
    public ArrayList<NGram> NGramsList;

    // Create a TransitionRule (constructor)
    public TransitionRule() {
        this.NGramsList = new ArrayList<> ();
    }

    // gets the NGram stored in index i
    public NGram get(int i) {
        return NGramsList.get(i);
    }

    // this adds an NGram to the TransitionRule
    public void addNGram( NGram n) {
        NGramsList.add(n);
    }

    // find the length of the TransitionRule
    public int size() {
        return NGramsList.size();
    }

    // make a string of the NGrams in the TransitionRule
    @Override
    public String toString( ) {
        String rv = "";
        for (NGram n : NGramsList) {
            rv += n.toString() + " ";
        }
        return rv;
    }

}
