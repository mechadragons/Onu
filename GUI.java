import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.Dimension;

public class GUI {
    private static GUI instance;
    JFrame unoScreen = new JFrame("Uno");
    DeckImage deckImage = new DeckImage("cards.png");
    DeckImage cardBackImage = new DeckImage("cardBack.png");
    private GUI() {
        unoScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        unoScreen.setLayout(null);
        Dimension screenSize = new Dimension(1000, 700);
        unoScreen.setPreferredSize(screenSize);
        unoScreen.pack();
        unoScreen.setVisible(true);
    }

    public static GUI getInstance() { //Returns a deck
        if (instance == null) {
            instance = new GUI();
        }
        return instance;
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

    public void drawDiscard(Card topCard) {
        drawCard(topCard, getWidth() / 2 + deckImage.WIDTH / 2, getHeight() / 2 - deckImage.HEIGHT / 2);
    }

    public void drawDeck() {
        JLabel deckLabel = new JLabel("The deck should appear here");
        BufferedImage cardBackImage = new BufferedImage(deckImage.WIDTH, deckImage.HEIGHT, BufferedImage.TYPE_INT_ARGB);
        deckLabel.setBounds(getWidth() / 2 + deckImage.WIDTH / 2, getHeight() / 2 - deckImage.HEIGHT / 2, deckImage.WIDTH, deckImage.HEIGHT);
        unoScreen.getContentPane().add(deckLabel);
        deckLabel.setIcon(new ImageIcon(cardBackImage));
    }
}