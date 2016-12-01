package blackjack.logic;

import java.util.ArrayList;

/**
 * Class Hand represents a single hand of cards.
 *
 * @author Jari Avikainen
 */
public class Hand {

    private final ArrayList<Card> contents;

    private final int[] cardValues;

    /**
     * Generates a new, empty hand of cards.
     */
    public Hand() {
        this.cardValues = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
        this.contents = new ArrayList<>();
    }

    public ArrayList<Card> getContents() {
        return contents;
    }

    /**
     * Add card to the contents of the hand.
     *
     * @param card The card to be added.
     */
    public void add(Card card) {
        this.contents.add(card);
    }

    /**
     * Calculate and return the value of the hand according to standard
     * blackjack rules.
     *
     * @return The value of the hand as an integer.
     */
    public int getValue() {
        int value = 0;
        boolean containsAce = false;
        boolean containsTen = false;
        for (Card card : contents) {
            if (card.getRank() == 1) {
                containsAce = true;
            }
            value += cardValues[card.getRank()];
        }
        if (containsAce && value < 12) {
            value += 10;
        }
        return value;
    }

    /**
     * Check whether the hand is a blackjack.
     *
     * @return True, if the hand is a blackjack, false otherwise.
     */
    public boolean isBlackJack() {
        return (this.contents.size() == 2 && this.getValue() == 21);
    }

    /**
     * Checks whether the hand contains at least one ace.
     *
     * @return True, if the hand contains at least one ace, false otherwise.
     */
    public boolean containsAce() {
        for (Card card : contents) {
            if (card.getRank() == 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks whether the hand is bust, i.e. has a value of more than 21.
     *
     * @return True, if the hand is bust, false otherwise.
     */
    public boolean isBust() {
        return (this.getValue() > 21);
    }

    /**
     * Clears the contents of the hand.
     *
     */
    public void clear() {
        this.contents.clear();
    }

}
