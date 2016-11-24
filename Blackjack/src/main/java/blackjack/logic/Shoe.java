package blackjack.logic;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

/**
 * This class contains the shoe (the deck of cards) used by the dealer.
 *
 * @author Jari Avikainen
 */
public class Shoe {

    private LinkedList<Card> contents;

    private final int decks;

    /**
     * Fills shoe with the provided number of decks. The decks are added to the
     * shoe, which is then shuffled.
     *
     * @param decks The number of 52-card decks to be used in the game.
     */
    public Shoe(int decks) {
        this.decks = decks;
        this.refill();
    }

    /**
     * Refills the shoe with the amount of decks provided in the constructor and
     * shuffles it afterwards. The cards possibly remaining in the shoe are
     * discarded.
     */
    public void refill() {
        this.contents = new LinkedList<>();
        for (int i = 0; i < this.decks; i++) {
            for (Suit suit : Suit.values()) {
                for (int j = 1; j <= 13; j++) {
                    this.contents.add(new Card(suit, j));
                }
            }
        }
        Collections.shuffle(this.contents, new Random());
    }

    /**
     * The method returns true if the shoe is empty.
     *
     * @return true if the shoe has no cards left.
     */
    public boolean hasCards() {
        return !this.contents.isEmpty();
    }

    /**
     * The method removes the next card from the shoe and returns it. If shoe
     * has no cards left, it is refilled first.
     *
     * @return The card taken from the shoe
     */
    public Card getCard() {
        if (!hasCards()) {
            refill();
        }
        return this.contents.pop();
    }

}
