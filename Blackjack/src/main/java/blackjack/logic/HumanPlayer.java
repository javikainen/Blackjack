package blackjack.logic;

/**
 *
 * @author Jari Avikainen
 */
public class HumanPlayer extends Player {

    public HumanPlayer(String name,int id, int money) {
        super(name, id, money);
        super.isAI = false;
    }

    @Override
    public void setBet(int userBet) {
        if (userBet > 0) {
            int newBet = userBet; // Use the bet chosen by the user
            super.money += super.currentBet - newBet;
            super.currentBet = newBet;
        }
    }

}
