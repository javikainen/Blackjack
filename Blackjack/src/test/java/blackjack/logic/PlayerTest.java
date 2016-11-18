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
        human = new HumanPlayer("Human", 1000);
        AI = new AIPlayer("AI", 1000);
    }
    
    @Test
    public void testIsAIFalsePositive() {
        assertFalse(human.isAI);
    }
    
    @Test
    public void testIsAIFalseNegative() {
        assertTrue(AI.isAI);
    }
    
    @Test
    public void testGetName() {
        assertEquals("Human", human.getName());
    }
    
    public void testGetMoney() {
        assertEquals(1000, human.getMoney());
    }
    
    public void testAddMoney() {
        human.addMoney(100);
        assertEquals(1100, human.getMoney());
    }
    
    public void testAddNegativeMoney() {
        human.addMoney(-100);
        assertEquals(1000, human.getMoney());
    }
    
    
    
    
}
