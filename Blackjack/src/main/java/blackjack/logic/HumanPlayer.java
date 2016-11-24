package blackjack.logic;

/**
 * This class is the player controlled by a human.
 *
 * @author Jari Avikainen
 */
public class HumanPlayer extends Player {

    public HumanPlayer(String name, int id, int money) {
        super(name, id, money);
        isAI = false;
    }
}
