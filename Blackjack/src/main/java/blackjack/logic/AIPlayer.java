package blackjack.logic;

/**
 * This class is the AI version of the Player.
 *
 * @author Jari Avikainen
 */
public class AIPlayer extends Player {

    public AIPlayer(String name, int id, int money) {
        super(name, id, money);
    }

    @Override
    public boolean isAI() {
        return true;
    }

    @Override
    public void playHand(Shoe shoe) {
        while (getHand().getValue() < 17) {
            getHand().add(shoe.getCard());
        }
        if (getHand().getValue() == 17 && getHand().containsAce()) {
            getHand().add(shoe.getCard());
        }

    }
}
