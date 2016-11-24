package blackjack.logic;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jari Avikainen
 */
public class BlackjackLogicTest {

    public BlackjackLogicTest() {
    }

    BlackjackLogic gameLogic;

    @Before
    public void setUp() {
        gameLogic = new BlackjackLogic(2, 1, 1000);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testConstructorRefusesInvalidArguments() {
            gameLogic = new BlackjackLogic(-1, 1, 1000);
            gameLogic = new BlackjackLogic(3, 1, 1000);
            gameLogic = new BlackjackLogic(2, 0, 1000);
            gameLogic = new BlackjackLogic(2, 1, 0);
        assertTrue(true);
    }
    
    @Test
    public void testNewBlackjackLogicContainsHumanPlayer() {
        List<Player> players = gameLogic.getPlayers();
        boolean containsHuman = false;
        for (Player player : players) {
            if (!player.isAI()) {
                containsHuman = true;
            }
        }
        assertTrue(containsHuman);
    }

    @Test
    public void testNewBlackJackLogicHasCorrentNumberOfAIPlayers() {
        List<Player> players = gameLogic.getPlayers();
        int numAIs = 0;
        for (Player player : players) {
            if (player.isAI()) {
                numAIs++;
            }
        }
        assertEquals(2, numAIs);
    }

    @Test
    public void testgetNextPlayerGivesPlayersInOrder() {
        for (int i = 0; i < 3; i++) {
            Player player = gameLogic.getNextPlayer();
            assertEquals(gameLogic.getPlayers().get(i), player);
        }
        assertEquals(null, gameLogic.getNextPlayer());
        assertEquals(gameLogic.getPlayers().get(0), gameLogic.getNextPlayer());
    }
    
    @Test
    public void AIPlayersHaveCorrectNamesAndIDs() {
        for (int i = 0; i < 2; i++) {
            Player player = gameLogic.getNextPlayer();
            while (!player.isAI) {
                player = gameLogic.getNextPlayer();
            }
            assertEquals("AI " + (i + 1), player.getName());
            assertEquals(i + 1, player.getID());
        }
    }
    
    @Test
    public void testGetPlayerHand() {
        Player player = gameLogic.getNextPlayer();
        player.addCard(new Card(Suit.CLUBS, 1));
        player.addCard(new Card(Suit.CLUBS, 11));
        Hand hand = gameLogic.getPlayerHand(player);
        List<Card> contents = hand.getContents();
        assertEquals(2, contents.size());
        Card first = contents.get(0);
        Card second = contents.get(1);
        assertTrue(first.getSuit() == Suit.CLUBS && first.getRank() == 1);
        assertTrue(second.getSuit() == Suit.CLUBS && second.getRank() == 11);
    }
    
    @Test
    public void testSetBets() {
        gameLogic.setBets(20);
        for (Player player : gameLogic.getPlayers()) {
            if (!player.isAI()) {
                assertEquals(20, player.getCurrentBet());
            }
            if (player.isAI()) {
                assertEquals(10, player.getCurrentBet());
            }
        }
    }

}
