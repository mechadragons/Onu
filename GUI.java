import java.awt.image.BufferedImage;
import javax.swing.*;

public class GUI {
    JFrame unoScreen = new JFrame("Uno");
    DeckImage deckImage = new DeckImage("cards.png");
    public GUI() {
        unoScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        unoScreen.setLayout(null);
        unoScreen.setSize(1000, 700);
        unoScreen.setVisible(true);
    }

    void drawCard(Card card, int x, int y) {
        JLabel cardLabel = new JLabel("A " + card.color + " " + card.symbol + " should appear here");
        BufferedImage cardImage = deckImage.getImage(card);
        cardLabel.setBounds(x, y, deckImage.WIDTH, deckImage.HEIGHT);
        unoScreen.getContentPane().add(cardLabel);
        cardLabel.setIcon(new ImageIcon(cardImage));
    }

    public int getWidth() {
        return unoScreen.getWidth();
    }

    public int getHeight() {
        return unoScreen.getHeight();
    }
}