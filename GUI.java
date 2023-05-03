import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;

public class GUI {
    private static GUI instance;
    JFrame unoScreen = new JFrame("Uno");
    DeckImage deckImage = new DeckImage("cards.png");
    DeckImage cardBackImage = new DeckImage("cardBack.png");
    int halfScreenWidth;
    int halfScreenHeight;

    private GUI() {
        unoScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        unoScreen.setLayout(null);
        Dimension screenSize = new Dimension(1000, 700);
        unoScreen.setPreferredSize(screenSize);
        unoScreen.pack();
        unoScreen.setVisible(true);
        halfScreenWidth = getWidth() / 2;
        halfScreenHeight = getHeight() / 2;
    }

    public static GUI getInstance() { //Returns a GUI
        if (instance == null) {
            instance = new GUI();
        }
        return instance;
    }

    void drawCard(Card card, int x, int y) {
        JButton cardButton = new JButton();
        cardButton.setBorder(null);
        cardButton.setContentAreaFilled(false);
        BufferedImage cardImage = deckImage.getImage(card);
        cardButton.setBounds(x, y, deckImage.WIDTH, deckImage.HEIGHT);
        unoScreen.getContentPane().add(cardButton);
        cardButton.setIcon(new ImageIcon(cardImage));
    }

    void drawCard(int x, int y) {
        JLabel cardLabel = new JLabel("The deck should appear here");
        BufferedImage cardImage = deckImage.getImage();
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
        int x = halfScreenWidth + 20;
        int y = halfScreenHeight - deckImage.HEIGHT / 2;
        JLabel discardLabel = new JLabel("The discard pile should appear here");
        BufferedImage cardImage = deckImage.getImage(topCard);
        discardLabel.setBounds(x, y, deckImage.WIDTH, deckImage.HEIGHT);
        unoScreen.getContentPane().add(discardLabel);
        discardLabel.setIcon(new ImageIcon(cardImage));
    }

    public void drawDeck() {
        int x = halfScreenWidth - deckImage.WIDTH - 20;
        int y = halfScreenHeight - deckImage.HEIGHT / 2;
        drawCard(x, y);
    }

    public void drawPlayers(String[] players) {
        int numPlayers = players.length;
        Hands hands = Hands.getInstance(numPlayers);
        Hand hand;
        int playerNum = 1;
        int panelWidth = 102;
        int panelHeight = 100;
        int margins = getWidth() - panelWidth * numPlayers;
        int numMargins = numPlayers - 1;
        int margin = 20;
        int pos;

        pos = (margins - margin * numMargins) / 2;
        margin += panelWidth;

        for (String player : players) {
            JPanel playerPanel = makePlayerPanel(pos, 20, panelWidth, panelHeight);
            pos += margin;

            JLabel playerLabel = new JLabel(player);
            playerPanel.add(playerLabel);
            playerLabel.setHorizontalAlignment(SwingConstants.CENTER);

            hand = hands.getHand(playerNum);
            JLabel handLabel = new JLabel("Cards: " + Integer.toString(hand.getLength()));
            playerPanel.add(handLabel);
            handLabel.setHorizontalAlignment(SwingConstants.CENTER);
            handLabel.setVerticalAlignment(SwingConstants.BOTTOM);

            unoScreen.validate();
        }
    }

    private JPanel makePlayerPanel(int x, int y, int width, int height) {
        JPanel playerPanel = new JPanel();
        playerPanel.setBackground(Color.gray);
        playerPanel.setLayout(new BoxLayout(playerPanel, BoxLayout.PAGE_AXIS));
        unoScreen.add(playerPanel);
        playerPanel.setLocation(x, y);
        playerPanel.setSize(width, height);

        return playerPanel;
    }
}