package blackjack.logic;

import java.util.ArrayList;

/**
 * This class represents the dealer. Dealer is currently not used, but it's
 * functionality is contained in the BlackjackLogic class.
 *
 * @author Jari Avikainen
 */
public class Dealer extends Player {

    public Dealer(String name, int id, int money) {
        super(name, id, money);
    }

    @Override
    public void adjustBet(int newBet) {
    }

    @Override
    public boolean isAI() {
        return true;
    }

    @Override
    public boolean isDealer() {
        return true;
    }

    @Override
    public void playHand(Shoe shoe) {
        while (getHand().getValue() < 17) {
            getHand().add(shoe.getCard());
        }
    }

}
