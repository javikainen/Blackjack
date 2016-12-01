package blackjack.logic;

/**
 * This class is the player controlled by a human.
 *
 * @author Jari Avikainen
 */
public class HumanPlayer extends Player {

    /**
     * Generates a new HumanPlayer using the given parameters.
     *
     * @param name The name of the player
     * @param id The id used for connecting the player to a proper playing are
     * in the UI
     * @param money The money player has when starting the game
     */
    public HumanPlayer(String name, int id, int money) {
        super(name, id, money);
    }

    @Override
    public boolean isAI() {
        return false;
    }

    @Override
    public void playHand(Shoe shoe) {
    }

}
