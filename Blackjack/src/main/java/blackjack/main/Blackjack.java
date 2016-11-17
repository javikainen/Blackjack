package blackjack.main;

import blackjack.gui.*;
import javax.swing.SwingUtilities;


/**
 *
 * @author Jari Avikainen
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Blackjack());
    }
}
