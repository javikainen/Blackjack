package blackjack.logic;

import java.util.Objects;

/**
 * This class is used for storing single playing cards.
 *
 * @author Jari Avikainen
 */
public class Card {

    private final Suit suit;
    private final int rank;

    /**
     * Generates a new card with given suit and rank.
     *
     * @param suit The suit of the generated card.
     * @param rank The rank of the generated card.
     */
    public Card(Suit suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Card other = (Card) obj;
        if (this.suit != other.suit) {
            return false;
        }
        if (this.rank != other.rank) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.suit);
        hash = 59 * hash + this.rank;
        return hash;
    }

}
