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

    @Before
    public void setUp() {
        human = new HumanPlayer("Human", 1, 1000);
        AI = new AIPlayer("AI", 2, 1000);
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
        human.setBet(1);
        assertEquals(1, human.getCurrentBet());
    }

    @Test
    public void testNegativeOrZeroBetIsIgnored() {
        human.setBet(10);
        human.setBet(0);
        assertEquals(10, human.getCurrentBet());
        human.setBet(-1);
        assertEquals(10, human.getCurrentBet());
    }

    @Test
    public void testRaisingAndLoweringBetAffectsHumanPlayerMoneyProperly() {
        human.setBet(10);
        assertEquals(990, human.getMoney());
        human.setBet(5);
        assertEquals(995, human.getMoney());
    }

    @Test
    public void testSetBetChangesAICurrentBetProperly() {
        AI.setBet(1);
        assertEquals(5, AI.getCurrentBet());
    }

    @Test
    public void testSetBetAffectsAIPlayerMoneyProperly() {
        AI.setBet(1);
        assertEquals(995, AI.getMoney());
    }

}
