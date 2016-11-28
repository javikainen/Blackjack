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

    public BlackjackLogic(int numAIs, int numDecks, int startingMoney) {
        if (numAIs < 0 || numAIs > 2 || numDecks < 0 || startingMoney < 0) {
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

    public Hand getPlayerHand(Player player) {
        return player.getHand();
    }

    public void adjustBets(int userBet) {
        for (Player player : players) {
            if (!player.isAI()) {
                player.adjustBet(userBet);
            } else {
                player.adjustBet(chooseBet(player));
            }
        }
    }

    public int chooseBet(Player player) {
        return 10;
    }

    public void deal() {
        for (int i = 0; i < 2; i++) {
            for (Player player : players) {
                if (!shoe.hasCards()) {
                    shoe.refill();
                }
                player.addCard(shoe.getCard());
            }
        }
        nextPlayer = 0;
    }

    public void dealCard(Player player) {
        if (!shoe.hasCards()) {
            shoe.refill();
        }
        player.addCard(shoe.getCard());
    }

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

    public Hand getDealerHand() {
        return dealer.getHand();
    }

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
