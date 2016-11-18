package blackjack.logic;

/**
 *
 * @author Jari Avikainen
 */
public class AIPlayer extends Player {

    public AIPlayer(String name, int money) {
        super(name, money);
        super.isAI = true;
    }
    
    @Override
    public void playHand() {
        // Reserved  for further extension
    }

}
