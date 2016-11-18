package blackjack.logic;

import java.util.ArrayList;

/**
 *
 * @author Jari Avikainen
 */
public class BlackjackLogic {

    ArrayList<Player> players;
    Dealer dealer;
    int nextPlayer;
    Hand dealerHand;
    Shoe shoe;

    public BlackjackLogic() {
        players = new ArrayList<>();
        players.add(new HumanPlayer("Player 1", 1000));
    }

    public Hand getDealerHand() {
        return dealerHand;
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

    public Player resolvePlayer() {
        Player player = players.get(nextPlayer);
        if (player.isAI()) {
            // do something
            return player;
        } else {
            // do something else
            return player;
        }
    }
    
    public boolean isBust(Player player) {
        return player.getHand().getValue() > 21;
    }
}
