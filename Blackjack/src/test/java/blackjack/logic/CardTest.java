package blackjack.logic;

import java.util.Objects;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jari Avikainen
 */
public class CardTest {
    
    public CardTest() {
    }
    
    Card card;
    
    @Before
    public void setUp() {
        card = new Card(Suit.DIAMONDS, 1);
    }
    
    @Test
    public void testGetSuit() {
        assertEquals(Suit.DIAMONDS, card.getSuit());
    }

    @Test
    public void testGetRank() {
        assertEquals(1, card.getRank());
    }
    
    @Test
    public void testEquals() {
        assertTrue(card.equals(new Card(Suit.DIAMONDS, 1)));
        assertFalse(card.equals(new Card(Suit.DIAMONDS, 6)));
        assertFalse(card.equals(new Card(Suit.CLUBS, 1)));
        assertFalse(card.equals(null));
        assertFalse(card.equals(new Shoe(1)));
    }
    
    @Test
    public void testHashCode() {
        int correctHash = 3;
        correctHash = 59 * correctHash + Objects.hashCode(card.getSuit());
        correctHash = 59 * correctHash + card.getRank();
        assertEquals(correctHash, card.hashCode());
    }
    
}
