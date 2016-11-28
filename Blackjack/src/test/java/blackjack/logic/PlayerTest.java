package blackjack.logic;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jari Avikainen
 */
public class PlayerTest {

    public PlayerTest() {
    }

    Player human;
    Player AI;
    Player dealer;
    Shoe shoe;

    @Before
    public void setUp() {
        human = new HumanPlayer("Human", 1, 1000);
        AI = new AIPlayer("AI", 2, 1000);
        dealer = new Dealer("Dealer", 3, 0);
        shoe = new Shoe(1);
    }

    @Test
    public void testIsAIFalsePositive() {
        assertFalse(human.isAI());
    }

    @Test
    public void testIsAIFalseNegative() {
        assertTrue(AI.isAI());
    }

    @Test
    public void testGetName() {
        assertEquals("Human", human.getName());
    }

    @Test
    public void testGetMoney() {
        assertEquals(1000, human.getMoney());
    }

    @Test
    public void testAddMoney() {
        human.addMoney(1);
        assertEquals(1001, human.getMoney());
    }

    @Test
    public void testAddNegativeMoney() {
        human.addMoney(-1);
        assertEquals(1000, human.getMoney());
    }

    @Test
    public void testTakeMoney() {
        human.takeMoney(1);
        assertEquals(999, human.getMoney());
    }

    @Test
    public void testTakeNegativeMoney() {
        human.takeMoney(-1);
        assertEquals(1000, human.getMoney());
    }

    @Test
    public void testGetID() {
        assertEquals(1, human.getID());
    }

    @Test
    public void testNewPlayerHasEmptyHand() {
        assertTrue(human.getHand().getContents().isEmpty());
    }

    @Test
    public void testAfterAddingCardPlayerHandHas1Card() {
        human.addCard(new Card(Suit.CLUBS, 1));
        assertEquals(1, human.getHand().getContents().size());
    }

    @Test
    public void testPlayerHandIsEmptyAfterClearHand() {
        human.addCard(new Card(Suit.CLUBS, 1));
        human.clearHand();
        assertTrue(human.getHand().getContents().isEmpty());
    }

    @Test
    public void testCurrentBetForNewPlayerIs0() {
        assertEquals(0, human.getCurrentBet());
    }

    @Test
    public void testSetBetChangesHumanCurrentBetProperly() {
        human.adjustBet(1);
        assertEquals(1, human.getCurrentBet());
    }

    @Test
    public void testNegativeOrZeroBetIsIgnored() {
        human.adjustBet(10);
        human.adjustBet(0);
        assertEquals(10, human.getCurrentBet());
        human.adjustBet(-1);
        assertEquals(10, human.getCurrentBet());
    }

    @Test
    public void testRaisingAndLoweringBetAffectsPlayerMoneyProperly() {
        human.adjustBet(10);
        assertEquals(990, human.getMoney());
        human.adjustBet(5);
        assertEquals(995, human.getMoney());
    }

    @Test
    public void testDealerPlayHand() {
        // Dealer takes cards until value is 17 or more.
        dealer.playHand(shoe);
        assertTrue(dealer.getHand().getValue() >= 17);

        dealer.getHand().clear();

        // Dealer stands on hard 17
        dealer.addCard(new Card(Suit.CLUBS, 7));
        dealer.addCard(new Card(Suit.CLUBS, 11));
        dealer.playHand(shoe);
        assertEquals(2, dealer.getHand().getContents().size());

        dealer.getHand().clear();

        // Dealer stands on soft 17
        dealer.addCard(new Card(Suit.CLUBS, 6));
        dealer.addCard(new Card(Suit.CLUBS, 1));
        dealer.playHand(shoe);
        assertEquals(2, dealer.getHand().getContents().size());
    }

    @Test
    public void testAIPlayHand() {
        // AI takes cards until value is 17 or more.
        AI.playHand(shoe);
        assertTrue(AI.getHand().getValue() >= 17);

        AI.getHand().clear();

        // AI stands on hard 17
        AI.addCard(new Card(Suit.CLUBS, 7));
        AI.addCard(new Card(Suit.CLUBS, 11));
        AI.playHand(shoe);
        assertEquals(2, AI.getHand().getContents().size());

        AI.getHand().clear();

        // AI hits on soft 17
        AI.addCard(new Card(Suit.CLUBS, 6));
        AI.addCard(new Card(Suit.CLUBS, 1));
        AI.playHand(shoe);
        assertTrue(AI.getHand().getContents().size() > 2);
    }

    @Test
    public void testHumanPlayHandDoesNothing() {
        human.playHand(shoe);
        assertTrue(human.getHand().getContents().isEmpty());
    }

}
