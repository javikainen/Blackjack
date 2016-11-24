package blackjack.logic;

import java.util.ArrayList;

/**
 *
 * @author Jari Avikainen
 */
public class BlackjackLogic {

    private ArrayList<Player> players;
//    private Dealer dealer;
    private int nextPlayer;
    private Hand dealerHand;
    private final Shoe shoe;
    private int numberOfDecks = 1;
    private int numAIPlayers = 0;
    private int startingMoney = 1000;

    public BlackjackLogic() {
        players = new ArrayList<>();
        players.add(new HumanPlayer("Human", 0, startingMoney));
        for (int i = 0; i < numAIPlayers; i++) {
            players.add(new AIPlayer("AI " + (i + 1), i + 1, startingMoney));
        }
        shoe = new Shoe(numberOfDecks);
        dealerHand = new Hand();
        nextPlayer = 0;
    }

    public Hand getPlayerHand(Player player) {
        return player.getHand();
    }

    public void setBets(int userBet) {
        for (Player player : players) {
            player.setBet(userBet);
        }
    }

    public void deal() {
        for (int i = 0; i < 2; i++) {
            for (Player player : players) {
                if (!shoe.hasCards()) {
                    shoe.shuffle();
                }
                player.addCard(shoe.getCard());
            }
            dealerHand.add(shoe.getCard());
        }
        nextPlayer = 0;
    }

    public Card dealCard() {
        if (!shoe.hasCards()) {
            shoe.shuffle();
        }
        return shoe.getCard();
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
            // do something
            return;
        } else {
            throw new IllegalArgumentException("playAIHand() argument is not an AI player!");
        }
    }

    public void playDealerHand() {
        while (dealerHand.getValue() < 17) {
            dealerHand.add(shoe.getCard());
        }
    }

    public boolean isBust(Player player) {
        return player.getHand().isBust();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Hand getDealerHand() {
        return dealerHand;
    }
    
    public void payWinnings() {
        for (Player player : players) {
            if (player.getHand().isBust()) {
                player.takeMoney(player.currentBet);
            } else if (player.getHand().isBlackJack() && !dealerHand.isBlackJack()) {
                player.addMoney(player.currentBet * 3 / 2);
            } else if (dealerHand.isBust()) {
                player.addMoney(player.currentBet);
            } else if (player.getHand().getValue() > dealerHand.getValue()) {
                player.addMoney(player.currentBet);
            } else if (player.getHand().getValue() < dealerHand.getValue()) {
                player.takeMoney(player.currentBet);
            }
            player.clearHand();
        }
        dealerHand.clear();
    }
}
