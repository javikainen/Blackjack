package blackjack.logic;

/**
 *
 * @author Jari Avikainen
 */
public abstract class Player {

    protected final String name;
    protected int money;
    protected boolean isAI;
    protected int currentBet;
    protected Hand hand;

    public Player(String name, int money) {
        this.name = name;
        this.money = money;
        this.currentBet = 0;

    }

    public int getCurrentBet() {
        return this.currentBet;
    }

    //    public void clearBet() {
    //        this.currentBet = 0;
    //    }
    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public void addMoney(int amount) {
        if (amount > 0) {
            this.money += amount;
        }
    }

    public Hand getHand() {
        return hand;
    }

    public void clearHand() {
        this.hand = new Hand();
    }

    public void addCard(Card card) {
        this.hand.add(card);
    }

    public void setBet(int userBet) {
        int newBet = 5;
        this.money += this.currentBet - newBet;
        this.currentBet = newBet;
    }

    public boolean isAI() {
        return this.isAI;
    }

    public void playHand() {

    }
}
