/*********************************************
 * Assignment 7
 * Name: Adina Abudushalamu
 * E-mail: aadina@unm.edu
 * Course: CS 152 - Section 001
 * Date submitted: 10/23/2020
 *
 * A program that plays a word guessing game
***********************************************/

import java.util.Scanner;

public class WordGuessing {
    
    /** We'll use asterisks for unknown letters. */
    public static final char BLANK = '*';

    /**
     * Picks a random word from the dictionary.
     * @param dictionary An array of words.
     * @return Randomly chosen word from dictionary.
     */
    public static String pickWordAtRandom(String[] dictionary) {
        String wordPicked = dictionary[(int)(Math.random() * dictionary.length)];
        return wordPicked;
    }
    
    /** 
     * Have all the letters in the guess been filled in?
     * @param knownLetters Array of letters that player knows.
     * @return True if knownLetters has blanks.
     */
    public static boolean isIncomplete(char[] knownLetters) {
        for (int i = 0; i < knownLetters.length; i++){
        	if (knownLetters[i] == BLANK)
        		return true;
        }
        return false;
    }

    /**
     * Checks to see if guessedLetter occurs at least once in word. If so,
     * sets the corresponding elements of knownLetters to that letter and
     * returns true. If not, leave knownLetters alone and returns false.
     * @param knownLetters Array of letters that player knows.
     * @param guessedLetter Letter that player has guessed.
     * @param word The word we are checking.
     * @return True if letter was found in word.
     */
    public static boolean updateWithGuess(char[] knownLetters,
                                          char guessedLetter,
                                          String word) {
        for (int i = 0; i < word.length(); i++){
        	if (word.charAt(i) == guessedLetter){
        			for (int j = 0; j < word.length(); j++){
        				if (word.charAt(j) == guessedLetter)
        					knownLetters[j] = guessedLetter;
        			}
        			return true;
        	}
        }
        return false;
    }


    /**
     * This method prints ASCII art of the person.
     * @param guesses The number of guesses remaining.
     */
    public static void drawAsciiMan(int guesses){

        System.out.println(" |" );

        // head (or not)
        if(guesses < 6) {
            System.out.println(" |     O");
        } else {
            System.out.println(" |");
        }


        // Body and arms
        switch (guesses) {

        case 6:
        case 5:
            // no body
            System.out.println(" |");
            break;

        case 4:
            // body, no arms
            System.out.println(" |     |");
            break;

        case 3:
            // body and left arm
            System.out.println(" |    /|");
            break;

        default:
            // body and both arms
            System.out.println(" |    /|\\");
            break;

        }

        // Legs
        switch (guesses) {

        case 1:
            // left leg
            System.out.println(" |    /");
            break;

        case 0:
            // both legs
            System.out.println(" |    / \\");
            break;

        default:
            // no legs
            System.out.println(" |");
            break;

        }

    }

    /** 
     * Plays a text-based word guessing game.
     */
    public static void main(String[] args) {
        // Let's use some animals for our words in this game.
        String[] words = {"aardvark", "alligator", "alpaca", "anteater",
                          "antelope", "ape", "armadillo", "baboon",
                          "badger", "bat", "bear", "beaver", "bison", "boar",
                          "buffalo", "bull", "bunny", "burro", "camel",
                          "canary", "capybara", "cat", "chameleon", "cheetah",
                          "chimpanzee", "chinchilla", "chipmunk", "colt",
                          "cougar", "cow", "coyote", "crocodile", "crow",
                          "deer", "dingo", "doe", "dog", "donkey", "dormouse",
                          "elephant", "elk", "ewe", "fawn", "ferret", "finch",
                          "fish", "fox", "frog", "gazelle", "giraffe", "gnu",
                          "goat", "gopher", "gorilla", "hamster", "hare",
                          "hedgehog", "hippopotamus", "hog", "horse", "hyena",
                          "ibex", "iguana", "impala", "jackal", "jaguar",
                          "kangaroo", "kid", "kitten", "koala", "lamb",
                          "lemur", "leopard", "lion", "lizard", "llama",
                          "lynx", "mare", "marmoset", "marten", "mink",
                          "mole", "mongoose", "monkey", "moose", "mouse",
                          "mule", "muskrat", "mustang", "newt", "ocelot",
                          "opossum", "orangutan", "oryx", "otter", "ox",
                          "panda", "panther", "parakeet", "parrot", "pig",
                          "platypus", "pony", "porcupine", "porpoise", "puma",
                          "puppy", "rabbit", "raccoon", "ram", "rat",
                          "reindeer", "reptile", "rhinoceros", "salamander", 
                          "seal", "sheep", "shrew", "skunk", "sloth", "snake",
                          "squirrel", "stallion", "steer", "tapir", "tiger",
                          "toad", "turtle", "vicuna", "walrus", "warthog",
                          "weasel", "whale", "wildcat", "wolf", "wolverine",
                          "wombat", "woodchuck", "yak", "zebra"};
        

        System.out.println("Hello! Try to guess my word.");

        String word = pickWordAtRandom(words);

        System.out.println(word);
        
        char[] known = new char[word.length()];
        for(int i = 0; i < known.length; i++) {
            known[i] = BLANK;
        }

        Scanner sc = new Scanner(System.in);
        int guesses = 6;
        while(guesses > 0 && isIncomplete(known)) {
            System.out.println(); // blank line between guesses
            System.out.println("Guesses remaining: " + guesses);
            drawAsciiMan(guesses);
            System.out.println("Word: " + new String(known));

            System.out.print("Guess a letter: ");
            // grabbing the entire next token and then taking only 1st char
            char letter = sc.next().trim().charAt(0);

            boolean foundLetter = updateWithGuess(known, letter, word);
            if(!foundLetter) {
                System.out.println("Sorry, there is no " + letter);
                guesses--;
            }
        }

        drawAsciiMan(guesses);
        System.out.println("Word: " + new String(known));
        if(isIncomplete(known)) {
            System.out.println("You lose. The word was: " + word);
        } else {
            System.out.println("Hooray! You win!");
        }
    }

}