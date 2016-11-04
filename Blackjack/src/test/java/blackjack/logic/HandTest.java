package blackjack.logic;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jari Avikainen
 */
public class HandTest {

    public HandTest() {
    }

    Hand hand;

    @Before
    public void setUp() {
        hand = new Hand();
    }

    @Test
    public void testEmptyHandIsEmpty() {
        assertEquals(0, hand.getContents().size());
    }

    @Test
    public void testEmptyHandsValueIs0() {
        assertEquals(0, hand.getValue());
    }

    @Test
    public void testGetContentsAfterAdding1Card() {
        hand.add(new Card(Suit.SPADES, 12));
        ArrayList<Card> contents = hand.getContents();
        if (contents.isEmpty() || contents.size() != 1) {
            fail();
        }
        Card card = contents.get(0);
        if (card.getRank() != 12 || card.getSuit() != Suit.SPADES) {
            fail();
        }
    }

    @Test
    public void testGetValueAfterAdding2Cards() {
        hand.add(new Card(Suit.SPADES, 12));
        hand.add(new Card(Suit.HEARTS, 5));
        assertEquals(15, hand.getValue());
    }

    @Test
    public void testGetValueWhenAceIs11() {
        hand.add(new Card(Suit.CLUBS, 1));
        hand.add(new Card(Suit.CLUBS, 7));
        assertEquals(18, hand.getValue());
    }

    @Test
    public void testGetValueWhenAceIs1() {
        hand.add(new Card(Suit.CLUBS, 1));
        hand.add(new Card(Suit.CLUBS, 7));
        hand.add(new Card(Suit.CLUBS, 5));
        assertEquals(13, hand.getValue());
    }

    @Test
    public void testIsBlackJackWhenHandIsBlackjack() {
        hand.add(new Card(Suit.CLUBS, 1));
        hand.add(new Card(Suit.DIAMONDS, 12));
        assertTrue(hand.isBlackJack());
    }

    @Test
    public void testIsBlackJackWhenHandIsNotBlackjack() {
        hand.add(new Card(Suit.CLUBS, 1));
        hand.add(new Card(Suit.DIAMONDS, 5));
        hand.add(new Card(Suit.SPADES, 5));
        if (hand.isBlackJack()) {
            fail();
        }
        hand.add(new Card(Suit.HEARTS, 3));
        hand.add(new Card(Suit.SPADES, 7));
        assertFalse(hand.isBlackJack());
    }

}
