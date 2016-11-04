package blackjack.logic;

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
    
}
