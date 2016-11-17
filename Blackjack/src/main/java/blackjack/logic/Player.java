package blackjack.logic;

/**
 *
 * @author Jari Avikainen
 */
public class Player {

    private final String name;

    private int money;
    
    private boolean isAI;

    private int currentBet;

    private Hand hand;

    public Player(String name, int money) {
        this.name = name;
        this.money = money;
        this.currentBet = 0;
        this.isAI = false;
    }

    public int getCurrentBet() {
        return this.currentBet;
    }

    public void clearBet() {
        this.currentBet = 0;
    }

    public String getName() {
        return name;
    }
    
    public boolean isAI() {
        return this.isAI;
    }

    public int getMoney() {
        return money;
    }

    public void addMoney(int amount) {
        this.money += amount;
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
        int newBet = userBet; // Get input from player
        this.money += currentBet - newBet;
        currentBet = newBet;
    }

    public void playHand() {
        
    }
}
