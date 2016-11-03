/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack.logic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jaria
 */
public class CardTest {
    
    public CardTest() {
    }
    
    Card card;
    
    @Before
    public void setUp() {
        card = new Card(Suit.DIAMONDS, 1);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getSuit method, of class Card.
     */
    @Test
    public void testGetSuit() {
        System.out.println("getSuit");
        Suit expResult = Suit.DIAMONDS;
        Suit result = card.getSuit();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRank method, of class Card.
     */
    @Test
    public void testGetRank() {
        System.out.println("getRank");
        Card instance = card;
        int expResult = 1;
        int result = instance.getRank();
        assertEquals(expResult, result);
    }
    
}
