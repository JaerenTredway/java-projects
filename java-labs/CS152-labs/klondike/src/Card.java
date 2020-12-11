/**
 * @version 1.0 2019-11-25
 * @author Jaeren William Tredway
 * This class builds a new card with a suit, rank, and a boolean indicating
 * if it is face up, and has methods for cards.
 */
public class Card {


    // INSTANCE MEMBER VARIABLES:
    private Rank rank;
    private Suit suit;
    private boolean faceUp = true;

    /** *****************************************************************
     * This is the constructor that builds a new card.
     * @param rank (type Rank): the card's rank from Ace to King
     * @param suit (type Suit): the card's suit (Heart, Diamond, Club, or
     *             Spade).
     */
    public Card(Rank rank, Suit suit) {

        this.rank = rank;
        this.suit = suit;
    }//******************************************************************


    /** *****************************************************************
     * This GETTER gets the card's rank.
     * @return (type Rank): returns the card's rank
     */
    public Rank getRank() {
        return rank;
    }//******************************************************************


    /** *****************************************************************
     * This GETTER gets the card's suit.
     * @return (type Suit): returns the card's suit
     */
    public Suit getSuit() {
        return suit;
    }//******************************************************************


    /** *****************************************************************
     * This finds out if the card is facing up.
     * @return (type boolean): returns true if the card is facing up
     */
    public boolean isFaceUp () {
        return faceUp;
    }//******************************************************************


    /** *****************************************************************
     * This finds out if the card is red.
     * @return (type boolean): returns true if the card is red
     */
    public boolean isRed () {
        if (getSuit().equals(Suit.HEARTS) ||
                getSuit().equals(Suit.DIAMONDS)) {
            return true;
        } else {
            return false;
        }
    }//******************************************************************


    /** *****************************************************************
     * This flips the card over
     */
    public void flipOver () {
        faceUp = !isFaceUp();
    }//******************************************************************


}//END of class Card
