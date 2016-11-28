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

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorRefusesInvalidArguments() {
        gameLogic = new BlackjackLogic(-1, 1, 1000);
        gameLogic = new BlackjackLogic(3, 1, 1000);
        gameLogic = new BlackjackLogic(2, 0, 1000);
        gameLogic = new BlackjackLogic(2, 1, 0);
//        assertTrue(true);
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
        for (int i = 0; i < 3; i++) {
            gameLogic = new BlackjackLogic(i, 0, 1000);
            List<Player> players = gameLogic.getPlayers();
            int numAIs = 0;
            for (Player player : players) {
                if (player.isAI() && !player.isDealer()) {
                    numAIs++;
                }
            }
            assertEquals(i, numAIs);
        }
    }

    @Test
    public void testgetNextPlayerGivesPlayersInOrder() {
        for (int i = 0; i < 4; i++) {
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
            while (!player.isAI()) {
                player = gameLogic.getNextPlayer();
            }
            assertEquals("AI " + (i + 1), player.getName());
            assertEquals(i * 2, player.getID());
        }
        gameLogic = new BlackjackLogic(1, 1, 1000);
        Player player = gameLogic.getNextPlayer();
        while (!player.isAI()) {
            player = gameLogic.getNextPlayer();
        }
        assertEquals("AI 1", player.getName());
        assertEquals(2, player.getID());
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
        gameLogic.adjustBets(20);
        for (Player player : gameLogic.getPlayers()) {
            if (!player.isAI()) {
                assertEquals(20, player.getCurrentBet());
            }
            if (player.isAI() && !player.isDealer()) {
                assertEquals(10, player.getCurrentBet());
            }
            if (player.isDealer()) {
                assertEquals(0, player.getCurrentBet());
            }
        }
    }

    @Test
    public void testPayWinningsClearsHands() {
        List<Player> players = gameLogic.getPlayers();
        Player p0 = players.get(0);
        Player p1 = players.get(1);
        Player p2 = players.get(2);
        Player dealer = players.get(3);
        dealer.addCard(new Card(Suit.CLUBS, 1));
        dealer.addCard(new Card(Suit.CLUBS, 11));
        p0.addCard(new Card(Suit.DIAMONDS, 11));
        p0.addCard(new Card(Suit.DIAMONDS, 1));
        p1.addCard(new Card(Suit.HEARTS, 11));
        p1.addCard(new Card(Suit.HEARTS, 5));
        p1.addCard(new Card(Suit.HEARTS, 6));
        p2.addCard(new Card(Suit.SPADES, 11));
        p2.addCard(new Card(Suit.SPADES, 5));
        p2.addCard(new Card(Suit.SPADES, 7));
        gameLogic.payWinnings();
        for (Player player : players) {
            assertTrue(player.getHand().getContents().isEmpty());
        }
    }

    @Test
    public void testPayWinningsWhenDealerHasBlackjack() {
        List<Player> players = gameLogic.getPlayers();
        for (Player player : players) {
            player.setCurrentBet(50);
        }
        Player p0 = players.get(0);
        Player p1 = players.get(1);
        Player p2 = players.get(2);
        Player dealer = players.get(3);
        dealer.addCard(new Card(Suit.CLUBS, 1));
        dealer.addCard(new Card(Suit.CLUBS, 11));
        p0.addCard(new Card(Suit.DIAMONDS, 11));
        p0.addCard(new Card(Suit.DIAMONDS, 1));
        p1.addCard(new Card(Suit.HEARTS, 11));
        p1.addCard(new Card(Suit.HEARTS, 5));
        p1.addCard(new Card(Suit.HEARTS, 6));
        p2.addCard(new Card(Suit.SPADES, 11));
        p2.addCard(new Card(Suit.SPADES, 5));
        p2.addCard(new Card(Suit.SPADES, 7));
        gameLogic.payWinnings();
        assertEquals(1000, p0.getMoney());
        assertEquals(950, p1.getMoney());
        assertEquals(950, p2.getMoney());
    }

    @Test
    public void testPayWinningsWhenDealerHas21() {
        List<Player> players = gameLogic.getPlayers();
        for (Player player : players) {
            player.setCurrentBet(50);
        }
        Player p0 = players.get(0);
        Player p1 = players.get(1);
        Player p2 = players.get(2);
        Player dealer = players.get(3);
        dealer.addCard(new Card(Suit.CLUBS, 4));
        dealer.addCard(new Card(Suit.CLUBS, 7));
        dealer.addCard(new Card(Suit.CLUBS, 11));
        p0.addCard(new Card(Suit.DIAMONDS, 11));
        p0.addCard(new Card(Suit.DIAMONDS, 1));
        p1.addCard(new Card(Suit.HEARTS, 11));
        p1.addCard(new Card(Suit.HEARTS, 5));
        p1.addCard(new Card(Suit.HEARTS, 6));
        p2.addCard(new Card(Suit.SPADES, 11));
        p2.addCard(new Card(Suit.SPADES, 12));
        gameLogic.payWinnings();
        assertEquals(1075, p0.getMoney());
        assertEquals(1000, p1.getMoney());
        assertEquals(950, p2.getMoney());
    }

    @Test
    public void testPayWinningsWhenDealerHas17() {
        List<Player> players = gameLogic.getPlayers();
        for (Player player : players) {
            player.setCurrentBet(50);
        }
        Player p0 = players.get(0);
        Player p1 = players.get(1);
        Player p2 = players.get(2);
        Player dealer = players.get(3);
        dealer.addCard(new Card(Suit.CLUBS, 7));
        dealer.addCard(new Card(Suit.CLUBS, 11));
        p0.addCard(new Card(Suit.DIAMONDS, 11));
        p0.addCard(new Card(Suit.DIAMONDS, 1));
        p1.addCard(new Card(Suit.HEARTS, 11));
        p1.addCard(new Card(Suit.HEARTS, 5));
        p1.addCard(new Card(Suit.HEARTS, 3));
        p2.addCard(new Card(Suit.SPADES, 11));
        p2.addCard(new Card(Suit.SPADES, 7));
        gameLogic.payWinnings();
        assertEquals(1075, p0.getMoney());
        assertEquals(1050, p1.getMoney());
        assertEquals(1000, p2.getMoney());
    }

    @Test
    public void testPayWinningsWhenDealerisBust() {
        List<Player> players = gameLogic.getPlayers();
        for (Player player : players) {
            player.setCurrentBet(50);
        }
        Player p0 = players.get(0);
        Player p1 = players.get(1);
        Player p2 = players.get(2);
        Player dealer = players.get(3);
        dealer.addCard(new Card(Suit.CLUBS, 6));
        dealer.addCard(new Card(Suit.CLUBS, 11));
        dealer.addCard(new Card(Suit.CLUBS, 12));
        p0.addCard(new Card(Suit.DIAMONDS, 11));
        p0.addCard(new Card(Suit.DIAMONDS, 1));
        p1.addCard(new Card(Suit.HEARTS, 2));
        p2.addCard(new Card(Suit.SPADES, 11));
        p2.addCard(new Card(Suit.SPADES, 7));
        p2.addCard(new Card(Suit.SPADES, 12));
        gameLogic.payWinnings();
        assertEquals(1075, p0.getMoney());
        assertEquals(1050, p1.getMoney());
        assertEquals(950, p2.getMoney());
    }

    @Test
    public void testDealCard() {
        Player player = new HumanPlayer("Test", 1, 1000);
        gameLogic.dealCard(player);
        assertEquals(1, player.getHand().getContents().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPlayAIHandRefusesHumanArgument() {
        Player human = new HumanPlayer("Human", 1, 1000);
        gameLogic.playAIHand(human);
    }

    @Test
    public void testPlayAIHand() {
        Player AI = new AIPlayer("AI", 1, 1000);
        gameLogic.playAIHand(AI);
        assertFalse(AI.getHand().getContents().isEmpty());
    }

    @Test
    public void testGetDealerHand() {
        List<Player> players = gameLogic.getPlayers();
        assertEquals(players.get(3).getHand(), gameLogic.getDealerHand());
    }

    @Test
    public void testAllPlayersHaveTwoCardsAfterDeal() {
        List<Player> players = gameLogic.getPlayers();
        gameLogic.deal();
        for (Player player : players) {
            assertEquals(2, player.getHand().getContents().size());
        }
    }

    @Test
    public void testFirstPlayerIsNextPlayerAfterDeal() {
        List<Player> players = gameLogic.getPlayers();
        gameLogic.getNextPlayer();
        gameLogic.deal();
        assertEquals(players.get(0), gameLogic.getNextPlayer());
    }

}
