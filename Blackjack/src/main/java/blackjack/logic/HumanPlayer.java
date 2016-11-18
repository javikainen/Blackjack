package blackjack.logic;

/**
 *
 * @author Jari Avikainen
 */
public class HumanPlayer extends Player {

    public HumanPlayer(String name, int money) {
        super(name, money);
        super.isAI = false;
    }

    @Override
    public void setBet(int userBet) {
        int newBet = userBet; // Use the bet chosen by the user
        super.money += super.currentBet - newBet;
        super.currentBet = newBet;
    }

}
