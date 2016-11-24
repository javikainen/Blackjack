package blackjack.logic;

import java.util.ArrayList;

/**
 * This class represents the dealer. Dealer is currently not used, but it's
 * functionality is contained in the BlackjackLogic class.
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
                player.addCard(shoe.getCard());
            }
            this.hand.add(shoe.getCard());
        }
    }

}
