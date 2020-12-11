
public enum RockPaperScissors {

    ROCK,
    PAPER,
    SCISSORS;
    
    public String toPrettyString() {
        String s = toString();
        return s.toLowerCase();
    }
    
    public boolean winsAgainst(RockPaperScissors other) {
        int thisNum = ordinal();
        int otherNum = other.ordinal();
        return thisNum == (otherNum + 1) % 3;
    }
}
