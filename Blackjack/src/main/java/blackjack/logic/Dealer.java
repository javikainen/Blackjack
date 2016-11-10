package blackjack.logic;

import java.util.ArrayList;

/**
 *
 * @author Jari Avikainen
 */
public class Dealer {

    Hand hand;
    Shoe shoe;
    ArrayList<Player> players;

    public Hand getHand() {
        return this.hand;
    }

    public void getBets() {
        for (Player player : players) {
            player.setBet();
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
            this.hand.add(shoe.getCard());
        }
    }
    
    public void resolveRound() {
        for (Player player : players) {
            resolveHand(player);
        }
        this.hand = new Hand();
    }

    public void resolveHand(Player player) {
        Choice playerChoice = player.getChoice();
        boolean playerWin = true;
        if (playerWin) {
            player.addMoney(player.getCurrentBet());
        } else {
            player.clearBet();
        }
        player.clearHand();
    }
    
    public void play() {
        while(true) {
            getBets();
            deal();
            resolveRound();
        }
    }

}
