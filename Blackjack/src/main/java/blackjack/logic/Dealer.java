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

    public Dealer(ArrayList<Player> players) {
        this.players = players;
        this.hand = new Hand();
        this.shoe = new Shoe(1);
    }
    
    public Hand getHand() {
        return this.hand;
    }

    public void deal() {
        for (int i = 0; i < 2; i++) {
            for (Player player : players) {
//                if (!shoe.hasCards()) {
//                    shoe.shuffle();
//                }
                player.addCard(shoe.getCard());
            }
            this.hand.add(shoe.getCard());
        }
    }

//    public void resolveRound() {
//        for (Player player : players) {
//            resolveHand(player);
//        }
//        this.hand = new Hand();
//    }

//    public void resolveHand(Player player) {
//        Choice playerChoice = player.getChoice();
//        boolean playerWin = true;
//        if (playerWin) {
//            player.addMoney(player.getCurrentBet());
//        } else {
//            player.clearBet();
//        }
//        player.clearHand();
//    }

}
