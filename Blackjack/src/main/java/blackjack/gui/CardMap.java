package blackjack.gui;

import blackjack.logic.Card;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Contains an image containing all cards. 
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

    /**
     * Constructs a new CardMap from an image read from the defined file.
     *
     */
    public CardMap() {
        String imageFile = "src/main/resources/cards.jpg";
        try {
            BufferedImage bigImg = ImageIO.read(new File(imageFile));
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

    /**
     * Returns an Image of the card given as a parameter.
     *
     * @param card The card whose image is returned.
     * @return Image containing an image of the card.
     */
    public Image getCardImage(Card card) {
        int row = card.getSuit().ordinal();
        int column = card.getRank() - 1;
        return cards[row * 13 + column];
    }

}
