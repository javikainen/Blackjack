package blackjack.logic;

import java.util.ArrayList;
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
            shoe.getCard();
        }
        assertFalse(shoe.hasCards());
    }

    @Test
    public void testShoeWith1DeckHas52DifferentCards() {
        shoe = new Shoe(1);
        Set<Card> cards = new HashSet<>();
        while (shoe.hasCards()) {
            cards.add(shoe.getCard());
        }
        assertEquals(52, cards.size());
    }

    @Test
    public void testShoeWith2DecksHas104Cards() {
        shoe = new Shoe(2);
        for (int i = 0; i < 104; i++) {
            shoe.getCard();
        }
        assertFalse(shoe.hasCards());
    }

    @Test
    public void testShoeWith2DecksHas52DifferentCards() {
        shoe = new Shoe(2);
        Set<Card> cards = new HashSet<>();
        while (shoe.hasCards()) {
            cards.add(shoe.getCard());
        }
        assertEquals(52, cards.size());
    }

    @Test
    public void testCardsInNewOrRefilledShoeAreNotInOrder() {
        shoe = new Shoe(1);

        boolean inOrder = true;

        // First round tests for a new shoe, second round tests a refilled shoe.
        for (int round = 0; round < 2; round++) {
            for (Suit suit : Suit.values()) {
                if (inOrder == false) {
                    break;
                }
                for (int i = 1; i < 14; i++) {
                    Card card = shoe.getCard();
                    if (card.getRank() != i || card.getSuit() != suit) {
                        inOrder = false;
                        break;
                    }
                }
            }
            assertEquals(false, inOrder);
        }
    }

    @Test
    public void testCardsHaveDifferentOrderForEveryFillingOfTheShoe() {
        shoe = new Shoe(1);
        ArrayList<Card> oldCards = new ArrayList<>();
        while (shoe.hasCards()) {
            oldCards.add(shoe.getCard());
        }

        boolean inOrder = true;

        for (Card card : oldCards) {
            if (shoe.getCard() != card) {
                inOrder = false;
                break;
            }
        }
        assertEquals(false, inOrder);
    }

}
