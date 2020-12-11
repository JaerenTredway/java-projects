/**
 * @author yourName
 * 5/4/2019
 * how to compile and run
 * description of how project works
 */ 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MarkovTextGenerator {

    //FIXME: move your filereader code into its own method:
    public ArrayList<String> fileReader (String filename) {
        //see class demo for filereader
    }


    //FIXME: make a method that takes the above list of words that you
    //extracted from the text and makes a list of NGrams from it:
    public ArrayList<NGram> createNGrams (int n,
                                          ArrayList<String> words) {
        //note: each NGram is "n" words long
        //hint: use a two-dimensional for-loop that puts a word from the
        //above list into an NGram, and also the words after it up to "n". So
        //n=3 should collect 3 consecutive words from the list, then the
        //index moves to the second word in the list and repeats, etc
    }


    //FIXME: make a method that builds a hashmap from the above list of
    //NGrams. Each NGram is a key in the hashmap, and there is a
    //TransitionRule as the value linked to each key. The TransitionRule is a
    //list of all the possible NGrams that follow the key-NGram anywhere in
    //the text:
    public static HashMap<NGram, TransitionRule> createHashMap
    (ArrayList<NGram> nGramsList) {

    }


    //FIXME: make a method that creates gibberish by taking the current key
    //in the hashmap and randomly selecting a NGram from it's
    //TransistionRule to be the next NGram printed out:
    public static String generateText (HashMap<NGram, TransitionRule> r) {

    }


    public static void main( String[] args ) throws IOException {

        //the main method needs to:
        //1. get the command line arguments
        //2. read the text file (use fileReader method)
        //3. make the list of NGrams (use createNGrams method)
        //4. make the hashmap (use createHashMap method)
        //5. make the output gibberish (uses generateText method)
        
        }//END main()
    }//END class MarkovTextGenerator
