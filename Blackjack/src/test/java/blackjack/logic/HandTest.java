package blackjack.logic;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jaria
 */
public class HandTest {
    
    public HandTest() {
    }

    Hand hand;
    
    @Before
    public void setUp() {
        hand = new Hand();
    }
    
    @After
    public void tearDown() {
    }

    @Test 
    public void testEmptyHandIsEmpty() {
        assertEquals(0, hand.getContents().size());
    }
    
    @Test
    public void testEmptyHandsValueIs0() {
        assertEquals(hand.getValue(), 0);
    }
    
    @Test
    public void testGetContentsAfterAdding1Card() {
        hand.add(new Card(Suit.SPADES, 12));
        ArrayList<Card> contents = hand.getContents();
        if (contents.isEmpty() || contents.size() != 1) fail();
        Card card = contents.get(0);
        if (card.getRank() != 12 || card.getSuit() != Suit.SPADES) fail();
    }

    @Test
    public void testGetValueAfterAdding2Cards() {
        hand.add(new Card(Suit.SPADES, 12));
        hand.add(new Card(Suit.HEARTS, 5));
        assertEquals(15, hand.getValue());
    }

//    @Test
//    public void testGetValue() {
//        System.out.println("getValue");
//        Hand instance = new Hand();
//        int expResult = 0;
//        int result = instance.getValue();
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
    @Test
    public void testIsBlackJackWhenHandIsBlackjack() {
        hand.add(new Card(Suit.CLUBS, 1));
        hand.add(new Card(Suit.DIAMONDS, 12));
        assertEquals(true, hand.isBlackJack());
    }

    @Test
    public void testIsBlackJackWhenHandIsNotBlackjack() {
        hand.add(new Card(Suit.CLUBS, 1));
        hand.add(new Card(Suit.DIAMONDS, 5));
        hand.add(new Card(Suit.SPADES, 5));
        assertEquals(false, hand.isBlackJack());
    }

}
