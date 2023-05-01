import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Graphics;

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

    public static GUI getInstance() { //Returns a GUI
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
        drawCard(topCard, 0, 0);
    }

    public void drawDeck() {
        int deckWidth = 486;
        int deckHeight = 759;
        JLabel deckLabel = new JLabel("The deck should appear here");
        BufferedImage cardBack = new BufferedImage(deckWidth, deckHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics g = cardBack.createGraphics();
        int x = getWidth() / 2;
        int y = getHeight() / 2;
        int halfCardWidth = deckImage.WIDTH / 2;
        int halfCardHeight = deckImage.HEIGHT / 2;
        g.drawImage(cardBack, x - halfCardWidth, y - halfCardHeight, x + halfCardWidth, y + halfCardHeight, 0, 0, deckWidth, deckHeight, null);
        deckLabel.setBounds(x - halfCardWidth, y - halfCardHeight, deckImage.WIDTH, deckImage.HEIGHT);
        unoScreen.getContentPane().add(deckLabel);
        deckLabel.setIcon(new ImageIcon(cardBack));
    }
}