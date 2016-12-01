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
    private final Hand hand;

    /**
     * Generates a new Player using the given parameters. The players current
     * bet is set to 0 and the player is generated a new empty hand of cards.
     *
     * @param name The name of the player
     * @param id The id used for connecting the player to a proper playing are
     * in the UI
     * @param money The money player has when starting the game
     */
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
     * Removes the given amount of money from the player. If the player runs out
     * of money, take the rest from player's current bet.
     *
     * @param amount The amount of money to be removed. amount has to be
     * positive
     */
    public void takeMoney(int amount) {
        if (amount > 0) {
            this.money -= amount;
            if (this.money < 0) {
                this.currentBet += this.money;
                this.money = 0;
            }
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
     * between the previous bet and the chosen bet. Trying to increase the bet
     * by more than the amount of money remaining does nothing. Classes
     * extending Player may call this method using adjusted parameter.
     *
     * @param newBet The amount chosen for the next bet. This has to be more
     * than zero.
     */
    public void adjustBet(int newBet) {
        if (newBet > 0 && newBet <= currentBet + money) {
            money += currentBet - newBet;
            currentBet = newBet;
        }
    }

    public void setCurrentBet(int bet) {
        this.currentBet = bet;
    }

    /**
     * Can be used to check whether the player is an AI or not in the sense that
     * AI players are supposed to be able to play their hands independently.
     *
     * @return true, if the player is an AI and false, if the player is
     * human-controlled.
     */
    public abstract boolean isAI();

    public boolean isDealer() {
        return false;
    }

    /**
     * Plays the current hand by taking more cards from the shoe until
     * satisfied. The exact implementation depends on the type of player.
     *
     * @param shoe The shoe from which the new cards are taken.
     */
    public abstract void playHand(Shoe shoe);
}
