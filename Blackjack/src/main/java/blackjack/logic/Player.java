package blackjack.logic;

/**
 * Player is an abstract class that represents a single player that can be
 * either human- or AI-controlled.
 *
 * @author Jari Avikainen
 */
public abstract class Player {

    private final int id;
    private final String name;
    private int money;
    private int currentBet;
    private Hand hand;

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

    /**
     * Adds the given amount of money to player.
     *
     * @param amount The amount of money to be added. amount has to be positive.
     */
    public void addMoney(int amount) {
        if (amount > 0) {
            this.money += amount;
        }
    }

    /**
     * Removes the given amount of money from the player
     *
     * @param amount The amount of money to be removed. amount has to be
     * positive
     *
     */
    public void takeMoney(int amount) {
        if (amount > 0) {
            this.money -= amount;
        }
    }

    public Hand getHand() {
        return hand;
    }

    /**
     * Remove all cards from player's hand.
     *
     */
    public void clearHand() {
        this.hand.clear();
    }

    /**
     * Add the given card to the player's hand. Adding a null card does nothing.
     *
     * @param card The card to be added.
     */
    public void addCard(Card card) {
        if (card != null) {
            this.hand.add(card);
        }
    }

    /**
     * Updates the player's bet to the chosen amount. This will increase or
     * decrease the amount of money the player has left by the difference
     * between the previous bet and the chosen bet.
     *
     * @param newBet The amount chosen for the next bet. This has to be more
     * than zero.
     */
    public void adjustBet(int newBet) {
        if (newBet > 0) {
            this.money += this.currentBet - newBet;
            this.currentBet = newBet;
        }
    }

    public void setCurrentBet(int bet) {
        this.currentBet = bet;
    }

    public abstract boolean isAI();

    public boolean isDealer() {
        return false;
    }

    public abstract void playHand(Shoe shoe);
}
