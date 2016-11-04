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
    
}
