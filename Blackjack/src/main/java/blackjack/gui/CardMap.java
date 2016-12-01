package blackjack.gui;

import blackjack.logic.Card;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Jari Avikainen
 */
public class CardMap {

    final int width = 91;
    final int height = 126;
    final int hspace = 11;
    final int vspace = 7;
    final int rows = 4;
    final int cols = 13;
    BufferedImage[] cards = new BufferedImage[rows * cols];

    public CardMap() {
        try {
            BufferedImage bigImg = ImageIO.read(new File("src/main/resources/cards.jpg"));
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    cards[(i * cols) + j] = bigImg.getSubimage(
                            j * (width + hspace),
                            i * (height + vspace),
                            width,
                            height
                    );
                }
            }
        } catch (IOException ex) {
        }
    }
    
    public Image getCardImage(Card card) {
        int row = card.getSuit().ordinal();
        int column = card.getRank() - 1;
        return cards[row * 13 + column];
    }
    
}
