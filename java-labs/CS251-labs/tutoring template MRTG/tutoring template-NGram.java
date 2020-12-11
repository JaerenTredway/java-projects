import java.util.ArrayList;

// each NGram is a list of words, n words long
public class NGram {

    // the small list of words that make up each NGram:
    public ArrayList<String> words;

    // constructor to make each NGram:
    public NGram() {
        this.words = new ArrayList<> ();
    }

    // a method to add a word into an NGram:
    void add(String word) {
        words.add(word);
    }

    // returns the size of the NGram:
    public int size() {
        return words.size();
    }

    // get a word from an NGram:
    public String get(int i) {
        return words.get(i);
    }

    // make a string from the NGram:
    @Override
    public String toString( ) {
        StringBuilder rv = new StringBuilder();
        for (String word : words) {
            rv.append(word).append(" ");
        }
        return rv.toString();
    }

}
