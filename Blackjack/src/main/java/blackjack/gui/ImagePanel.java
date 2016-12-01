package blackjack.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 * ImagePanel is used as a container for an image of a single card.
 *
 * @author Jari Avikainen
 */
class ImagePanel extends JPanel {

    private final Image img;

    /**
     * Generates a new ImagePanel using the image given as a parameter.
     * 
     * @param img The image to be shown in the ImagePanel.
     */
    public ImagePanel(Image img) {
        this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
}
