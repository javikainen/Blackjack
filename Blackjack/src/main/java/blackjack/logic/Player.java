package blackjack.logic;

/**
 *
 * @author Jari Avikainen
 */
public class Player {
    
    private final String name;
    
    private int money;

    private Hand hand;
    
    public Player(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
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

    public void addCard(Card card) {
        this.hand.add(card);
    }
    
}
