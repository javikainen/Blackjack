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
    
//    private int cardsLeft;

    public Shoe(int decks) {
        this.decks = decks;
        this.shuffle();
//        this.cardsLeft = decks * 52;
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
    
    public Card getCard() {
//        this.cardsLeft--;
        // If there are no cards left, fill the shoe again
        if (!hasCards()) {
            shuffle();
        }
        return this.contents.pop();
    }
    
}
