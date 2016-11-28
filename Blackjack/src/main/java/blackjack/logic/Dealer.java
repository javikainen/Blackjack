package blackjack.logic;

import java.util.ArrayList;

/**
 * This class is used mainly for storing the dealer's hand and logic for drawing
 * cards.
 *
 * @author Jari Avikainen
 */
public class Dealer extends Player {

    public Dealer(String name, int id, int money) {
        super(name, id, money);
    }

    /**
     * Ignores the parameter and does nothing.
     *
     * @param newBet 
     */
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
