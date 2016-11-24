package blackjack.logic;

/**
 * Enum Suit is used for representing the different suits of the playing cards.
 *
 * @author Jari Avikainen
 */
public enum Suit {

    DIAMONDS, HEARTS, CLUBS, SPADES;

    @Override
    public String toString() {
        switch (this) {
            case DIAMONDS:
                return "D";
            case HEARTS:
                return "H";
            case CLUBS:
                return "C";
            case SPADES:
                return "S";
            default:
                return "";
        }
    }
}
