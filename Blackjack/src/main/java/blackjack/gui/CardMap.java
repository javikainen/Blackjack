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
    final BufferedImage[] cards = new BufferedImage[rows * cols];
    final BufferedImage[] cardBacks = new BufferedImage[2];

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
            for (int i = 0; i < 2; i++) {
                cardBacks[i] = bigImg.getSubimage(14 * (width + hspace), 2 * i * (height + vspace), width, height);
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

    /**
     * Returns an image of the back of a card with the colour specified in the
     * parameter colour.
     *
     * @param color The colour of the returned back of card.
     * @return Returns an image of the back of a card.
     */
    public Image getCardBack(String color) {
        switch (color) {
            case "blue":
                return cardBacks[0];
            case "red":
                return cardBacks[1];
            default:
                throw new IllegalArgumentException();
        }
    }

    /**
     * Returns an image of a red back of a card.
     *
     * @return Image of a red back of a card.
     */
    public Image getCardBack() {
        return cardBacks[1];
    }

}
