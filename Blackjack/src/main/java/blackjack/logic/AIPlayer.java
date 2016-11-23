package blackjack.logic;

/**
 *
 * @author Jari Avikainen
 */
public class AIPlayer extends Player {

    public AIPlayer(String name, int id, int money) {
        super(name, id, money);
        super.isAI = true;
    }
    
    @Override
    public void playHand() {
        // Reserved  for further extension
    }

}
