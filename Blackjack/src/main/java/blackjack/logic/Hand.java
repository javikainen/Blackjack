package blackjack.logic;

import java.util.ArrayList;

/**
 *
 * @author Jari Avikainen
 */
public class Hand {
    
    private final ArrayList<Card> contents;
    
    private final int[] cardValues;

    public Hand() {
        this.cardValues = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
        this.contents = new ArrayList<>();
    }

    public ArrayList<Card> getContents() {
        return contents;
    }
    
    public void add(Card card) {
        this.contents.add(card);
    }
    
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

    public boolean isBlackJack() {
        return (this.contents.size() == 2 && this.getValue() == 21);
    }
    
    public void clear() {
        this.contents.clear();
    }
        
}
