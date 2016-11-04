package blackjack.gui;

/**
 *
 * @author Jari Avikainen
 */
public class Blackjack implements Runnable {
    
    @Override
    public void run() {
        new BlackjackUI().setVisible(true);
    }
    
}
