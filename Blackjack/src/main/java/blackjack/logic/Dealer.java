package blackjack.logic;

/**
 * This class is used mainly for storing the dealers hand and logic for drawing
 * cards.
 *
 * @author Jari Avikainen
 */
public class Dealer extends Player {

    /**
     * Generates a new dealer using given parameters.
     *
     * @param name The name of the dealer. This is "Dealer" by default.
     * @param id The id used for connecting the dealer to the corresponding play
     * area in the UI. This should be 3 for the dealer.
     * @param money The amount of money dealer has in the beginning. This should
     * be zero, since dealer doesn't place bets like ordinary players.
     */
    public Dealer(String name, int id, int money) {
        super(name, id, money);
    }

    /**
     * Ignores the parameter and does nothing.
     *
     * @param newBet Parameter is ignored.
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
        while (!handIsGoodEnough()) {
            getHand().add(shoe.getCard());
        }
    }

    private boolean handIsGoodEnough() {
        return (getHand().getValue() >= 17);
    }

}
