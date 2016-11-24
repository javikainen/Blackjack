package blackjack.logic;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jari Avikainen
 */
public class SuitTest {
    
    public SuitTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testToString() {
        assertEquals("C", Suit.CLUBS.toString());
        assertEquals("S", Suit.SPADES.toString());
        assertEquals("D", Suit.DIAMONDS.toString());
        assertEquals("H", Suit.HEARTS.toString());
    }
    
}
