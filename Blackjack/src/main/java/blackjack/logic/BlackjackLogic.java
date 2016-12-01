package blackjack.logic;

import java.util.ArrayList;

/**
 * This class is the main game logic class. BlackjackLogic keeps track of all
 * players, the shoe etc. and takes care of dealing cards, deciding the winners
 * and so on.
 *
 * @author Jari Avikainen
 */
public class BlackjackLogic {

    private ArrayList<Player> players;
    private int nextPlayer;
    private final Shoe shoe;
    private Dealer dealer;

    /**
     * Generate a new instance of BlackjackLogic using given parameters as the
     * settings for the game. Players are generated and added to ArrayList
     * players Players according to the order in which they will play their
     * hands.
     *
     * @param numAIs The amount of AI players participating in the game. Allowed
     * values are 0, 1 and 2.
     * @param numDecks Number of 52-card decks to be shuffled together into the
     * shoe.
     * @param startingMoney Amount of starting money given to the players.
     */
    public BlackjackLogic(int numAIs, int numDecks, int startingMoney) {
        if (numAIs < 0 || numAIs > 2 || numDecks < 1 || startingMoney <= 0) {
            throw new IllegalArgumentException();
        }
        players = new ArrayList<>();
        dealer = new Dealer("Dealer", 3, 0);
        if (numAIs == 2) {
            players.add(new AIPlayer("AI 1", 0, startingMoney));
        }
        players.add(new HumanPlayer("Human", 1, startingMoney));
        if (numAIs > 0) {
            players.add(new AIPlayer("AI " + numAIs, 2, startingMoney));
        }
        players.add(dealer);
        shoe = new Shoe(numDecks);
        nextPlayer = 0;
    }

    /**
     * Returns the hand belonging to the given player.
     *
     * @param player The player whose hand will be returned.
     * @return The current hand of cards belonging to the given player.
     */
    public Hand getPlayerHand(Player player) {
        return player.getHand();
    }

    /**
     * Requests each of the players to set their bet for the next round. The bet
     * chosen by the user is passed to the players as an argument.
     *
     * @param userBet The new bet chosen by the user.
     */
    public void adjustBets(int userBet) {
        for (Player player : players) {
            player.adjustBet(userBet);
        }
    }

    /**
     * Deals two cards to each of the players and the dealer.
     *
     */
    public void deal() {
        for (int i = 0; i < 2; i++) {
            for (Player player : players) {
                player.addCard(shoe.getCard());
            }
        }
        nextPlayer = 0;
    }

    /**
     * Deals one card to the player given as a parameter.
     *
     * @param player The Player to which the new card is dealt.
     */
    public void dealCard(Player player) {
        player.addCard(shoe.getCard());
    }

    /**
     * Returns the Player whose turn it is to play.
     *
     * @return Player whose turn it is at the moment or null, if all the players
     * (including the dealer) have played their turn.
     */
    public Player getNextPlayer() {
        Player player;
        if (nextPlayer >= players.size()) {
            player = null;
            nextPlayer = 0;
        } else {
            player = players.get(nextPlayer);
            nextPlayer++;
        }
        return player;
    }

    /**
     * Instructs the AI player given as a parameter to play its turn. Throws an
     * IllegalArgumentException if The Player given is not an AI.
     *
     * @param player The Player that should play its turn.
     */
    public void playAIHand(Player player) {
        if (player.isAI()) {
            player.playHand(shoe);
        } else {
            throw new IllegalArgumentException("playAIHand() argument is not an AI player!");
        }
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * Returns the dealer's hand.
     *
     * @return The dealer's hand.
     */
    public Hand getDealerHand() {
        return dealer.getHand();
    }

    /**
     * Goes through all of the players, evaluates their hands compared to the
     * dealer, and adjusts the player's money according to the results.
     *
     * Hands are cleared after resolving them.
     *
     */
    public void payWinnings() {
        for (Player player : players) {
            if (player.isDealer()) {
                player.clearHand();
                break;
            }
            if (player.getHand().isBust()) {
                player.takeMoney(player.getCurrentBet());
            } else if (dealer.getHand().isBlackJack() && !player.getHand().isBlackJack()) {
                player.takeMoney(player.getCurrentBet());
            } else if (player.getHand().isBlackJack() && !dealer.getHand().isBlackJack()) {
                player.addMoney(player.getCurrentBet() * 3 / 2);
            } else if (dealer.getHand().isBust()) {
                player.addMoney(player.getCurrentBet());
            } else if (player.getHand().getValue() > dealer.getHand().getValue()) {
                player.addMoney(player.getCurrentBet());
            } else if (player.getHand().getValue() < dealer.getHand().getValue()) {
                player.takeMoney(player.getCurrentBet());
            }
            player.clearHand();
        }
    }
}
