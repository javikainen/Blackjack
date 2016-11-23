package blackjack.logic;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jari Avikainen
 */

public class DealerTest {
 
    public DealerTest() {
    }
    
    ArrayList<Player> players;
    Dealer dealer;
    
    @Before
    public void setUp() {
        players = new ArrayList<>();
        players.add(new HumanPlayer("Human", 1, 1000));
        dealer = new Dealer(players);
    }
    
    @Test
    public void testDealerHandIsEmptyInBeginning() {
        assertEquals(0, dealer.getHand().getContents().size());
    }
    
    @Test
    public void testAfterDealingDealerHas2Cards() {
        dealer.deal();
        assertEquals(2, dealer.getHand().getContents().size());
    }
    
    @Test
    public void testAfterDealingPlayersHave2Cards() {
        dealer.deal();
        for (Player player : players) {
            assertEquals(2, player.getHand().getContents().size());
        }
    }
    
    @Test
    public void testIfShoeIsEmptyDealerFillsTheShoe() {
        while (dealer.shoe.hasCards()) {
            dealer.shoe.getCard();
        }
        dealer.deal();
        assertTrue(dealer.shoe.hasCards());
    }
}
