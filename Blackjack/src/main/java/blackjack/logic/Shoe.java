package blackjack.logic;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Jari Avikainen
 */
public class Shoe {

    private LinkedList<Card> contents;
    
    private final int decks;

    public Shoe(int decks) {
        this.decks = decks;
        this.shuffle();
    }
    
    public void shuffle() {
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
    
    public boolean hasCards() {
        return !this.contents.isEmpty();
    }
    
    public Card dealCard() {
        return this.contents.pop();
    }
    
}