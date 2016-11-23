package blackjack.logic;

/**
 *
 * @author Jari Avikainen
 */
public abstract class Player {

    final int id;
    final String name;
    int money;
    boolean isAI;
    int currentBet;
    Hand hand;

    public Player(String name, int id, int money) {
        this.name = name;
        this.id = id;
        this.money = money;
        this.currentBet = 0;
        this.hand = new Hand();
    }

    public int getCurrentBet() {
        return this.currentBet;
    }

    public String getName() {
        return this.name;
    }
    
    public int getID() {
        return this.id;
    }

    public int getMoney() {
        return this.money;
    }

    public void addMoney(int amount) {
        if (amount > 0) {
            this.money += amount;
        }
    }
    
    public void takeMoney(int amount) {
        if (amount > 0) {
            this.money -= amount;
        }
    }

    public Hand getHand() {
        return hand;
    }

    public void clearHand() {
        this.hand.clear();
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
