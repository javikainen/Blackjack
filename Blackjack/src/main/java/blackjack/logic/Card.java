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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (rank == 1) {
            sb.append("A");
        } else if (rank < 11) {
            sb.append(rank);
        }
        if (rank == 11) {
            sb.append("J");
        }
        if (rank == 12) {
            sb.append("Q");
        }
        if (rank == 13) {
            sb.append("K");
        }
        sb.append(suit.toString());
        return sb.toString();
    }
    
}
