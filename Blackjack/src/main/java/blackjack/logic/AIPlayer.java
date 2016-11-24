package blackjack.logic;

/**
 * This class is the AI version of the Player.
 *
 * @author Jari Avikainen
 */
public class AIPlayer extends Player {

    public AIPlayer(String name, int id, int money) {
        super(name, id, money);
        super.isAI = true;
    }
}
