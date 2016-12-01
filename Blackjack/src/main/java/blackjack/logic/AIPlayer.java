package blackjack.logic;

/**
 * This class is the AI version of the Player.
 *
 * @author Jari Avikainen
 */
public class AIPlayer extends Player {

    /**
     * Generates a new AIPlayer using the given parameters.
     *
     * @param name The name of the player
     * @param id The id used for connecting the player to a proper playing are
     * in the UI
     * @param money The money player has when starting the game
     */
    public AIPlayer(String name, int id, int money) {
        super(name, id, money);
    }

    @Override
    public boolean isAI() {
        return true;
    }

    @Override
    public void playHand(Shoe shoe) {
        while (getHand().getValue() < 17 || getHand().getValue() == 17 && getHand().containsAce()) {
            getHand().add(shoe.getCard());
        }
    }

    @Override
    public void adjustBet(int newBet) {
        super.adjustBet(10);
    }

}
