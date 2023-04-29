import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.*;

class DeckImage {
    BufferedImage deckImage;
    final int WIDTH = 85;
    final int HEIGHT = 133;

    DeckImage(String imageFile) {
        InputStream image = getClass().getResourceAsStream(imageFile);
        try {
            deckImage = ImageIO.read(image);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    BufferedImage getImage(Card card) {
        BufferedImage cardImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics g = cardImage.createGraphics();
        Coordinates coordinates = new Coordinates(card);
        g.drawImage(deckImage, 0, 0, WIDTH, HEIGHT, coordinates.x, coordinates.y, coordinates.x + WIDTH, coordinates.y + HEIGHT, null);
        return cardImage;
    }
}