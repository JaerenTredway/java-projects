import java.util.Random;

/**
 * @version 1.0 2019-11-25
 * @author Jaeren William Tredway
 * This class builds a deck of cards and provides methods for decks.
 */
public class Deck {

    private static final int TOTAL_DECK_SIZE = 52;

    //INSTANCE MEMBER VARIABLES:
    private Card[] deck;
    private int subDeckSize = 0;

    /** *****************************************************************
     * This is the constructor that builds a deck of cards.
     * The bottom card in the deck will be stored at index zero in the array.
     * "deck" objects can be either the entire deck, or each pile of cards
     * during game play.
     */
    public Deck() {
        this.deck = new Card[TOTAL_DECK_SIZE];
        this.subDeckSize = 0;
    }//******************************************************************


    /** *****************************************************************
     * This method adds a card to the top of this deck.
     *
     * @param card (type Card): The card to add.
     */
    public void add(Card card) {
        deck[subDeckSize] = card;
        subDeckSize++;
    }//******************************************************************


    /** *****************************************************************
     * Fills the deck with all the cards in a standard deck of cards.
     * Uses the Enum.values() method to get arrays of all the Rank
     * values and Suit values so I can relate int indices to the Enum values.
     */
    public void fill() {
        for (int i = 0; i < Suit.values().length; i++) {
            for (int j = 0; j < Rank.values().length; j++) {
                add(new Card(Rank.values()[j], Suit.values()[i]));
            }
        }

    }//******************************************************************


    /** *****************************************************************
     * Returns the nth card in this deck, where card 0 is the one on the
     * bottom. Assumes the deck is not empty. Does not modify the deck.
     *
     * @param n (type int): the index of the card you are looking for
     * @return (type Card): the card that is at the nth index
     */
    public Card getCardAt(int n) {
        return deck[n];

    }//******************************************************************


    /** *****************************************************************
     * Moves one card from the top of this deck to the top of the other deck.
     *
     * @param other (type Deck): the deck you are moving to
     */
    public void moveTo(Deck other) {
        other.add(this.deck[this.subDeckSize - 1]);
        this.deck[this.subDeckSize - 1] = null;
        subDeckSize -= 1;

    }//******************************************************************


    /** *****************************************************************
     * Moves the top n cards from the top of this deck to the top of the
     * other deck, maintaining their order so that the card that was on top
     * of this deck becomes the top card of the other deck.
     *
     * @param other (type Deck): the deck you are moving to
     * @param n     (type int): the top n cards to move
     */
    public void moveTo(Deck other, int n) {
        for (int i = 0; i < n; i++) {
            other.add(this.deck[subDeckSize - n + i]);
            this.deck[subDeckSize - n + i] = null;
        }
        this.subDeckSize -= n;

    }//******************************************************************


    /** *****************************************************************
     * Returns the number of cards in this deck.
     *
     * @return (type int): the number of cards
     */
    public int size() {
        int numCards = 0;

        for (int i = 0; i < deck.length; i++) {
            if (deck[i] != null)
                numCards++;
        }

        return numCards;
    }//******************************************************************


    /** *****************************************************************
     * Returns the top card on this deck. Returns null if the deck is empty.
     * Does not modify the deck.
     *
     * @return (type Card): the card at the top of the deck
     */
    public Card getTopCard() {
        if (deck.length == 0)
            return null;
        else
            return deck[0] == null ? null : deck[subDeckSize - 1];

    }//******************************************************************


    /** *****************************************************************
     * Randomly reorders the cards in this deck using Fisher-Yates shuffle.
     * Is able to correctly shuffle any non-empty deck.
     * research source: http://math.hws.edu/javanotes/source/chapter5/Deck.java
     * and https://dev.to/s_awdesh/everyday-im-shuffling-im-a-card--fire-1f8b
     */
    public void shuffle() {
        Random random = new Random();

        for (int i = size() - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            //swap:
            Card temp = deck[index];
            deck[index] = deck[i];
            deck[i] = temp;

        }
    }//******************************************************************


}//END of class Deck
