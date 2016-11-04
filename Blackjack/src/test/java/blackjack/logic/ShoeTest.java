package blackjack.logic;

import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Jari Avikainen
 */
public class ShoeTest {

    public ShoeTest() {
        
    }
    Shoe shoe;
    
    @Test
    public void testNewShoeIsNotEmpty() {
        shoe = new Shoe(1);
        assertTrue(shoe.hasCards());
    }
    
    @Test
    public void testShoeWith1DeckHas52Cards() {
        shoe = new Shoe(1);
        for (int i = 0; i < 52; i++) {
            shoe.dealCard();
        }
        assertFalse(shoe.hasCards());
    }
    
    @Test
    public void testShoeWith1DeckHas52DifferentCards() {
        shoe = new Shoe(1);
        Set<Card> cards = new HashSet<>();
        while (shoe.hasCards()) {
            cards.add(shoe.dealCard());
        }
        assertEquals(52, cards.size());
    }

    @Test
    public void testShoeWith2DecksHas104Cards() {
        shoe = new Shoe(2);
        for (int i = 0; i < 104; i++) {
            shoe.dealCard();
        }
        assertFalse(shoe.hasCards());
    }

    @Test
    public void testShoeWith2DecksHas52DifferentCards() {
        shoe = new Shoe(2);
        Set<Card> cards = new HashSet<>();
        while (shoe.hasCards()) {
            cards.add(shoe.dealCard());
        }
        assertEquals(52, cards.size());
    }

}
