package blackjack.logic;

import blackjack.gui.BlackjackUI;
import java.util.ArrayList;

/**
 *
 * @author Jari Avikainen
 */
public class BlackjackLogic {
    
    BlackjackUI ui;
    ArrayList<Player> players;
    Dealer dealer;
    
    public BlackjackLogic(BlackjackUI ui) {
        this.ui = ui;
    }
    
    public Hand getDealerHand() {
        return dealer.getHand();
    }
    
    public Hand getPlayerHand(Player player) {
        return player.getHand();
    }
    
    
    
    
}
