import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener{
    private static GUI instance;
    JFrame unoScreen = new JFrame("Uno");
    DeckImage deckImage = new DeckImage("cards.png");
    Hands hands;
    String[] playerArray;
    JButton deckButton;
    JButton nextTurn;
    boolean screen;
    boolean reversed;
    boolean playerWon;
    int halfScreenWidth;
    int halfScreenHeight;
    public int currentPlayer;
    public int numPlayers;

    private GUI() {
        unoScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        unoScreen.setLayout(null);
        Dimension screenSize = new Dimension(1000, 700);
        unoScreen.setPreferredSize(screenSize);
        unoScreen.pack();
        unoScreen.setVisible(true);
        halfScreenWidth = getWidth() / 2;
        halfScreenHeight = getHeight() / 2;
        currentPlayer = 1;
        deckButton = newButton();
        nextTurn = nextTurnButton();
        reversed = false;
        playerWon = false;
    }

    public static GUI getInstance() { //Returns a GUI
        if (instance == null) {
            instance = new GUI();
        }
        return instance;
    }

    void drawCard(Card card, int x, int y) {
        JButton cardButton = card.button;
        cardButton.setBounds(x, y, deckImage.WIDTH, deckImage.HEIGHT);
        unoScreen.getContentPane().add(cardButton);
        unoScreen.repaint();
    }

    void drawCard(int x, int y) {
        deckButton.setBounds(x, y, deckImage.WIDTH, deckImage.HEIGHT);
        unoScreen.getContentPane().add(deckButton);
        unoScreen.repaint();
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
        playerArray = players;
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

            playerNum++;
        }
    }

    public void drawPlayers() {
        drawPlayers(playerArray);
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

    public JButton newButton(Card card) {
        JButton cardButton = new JButton();
        cardButton.setBorder(null);
        cardButton.setContentAreaFilled(false);
        BufferedImage cardImage = deckImage.getImage(card);
        cardButton.addActionListener(this);
        cardButton.setIcon(new ImageIcon(cardImage));

        return cardButton;
    }

    JButton newButton() {
        JButton cardButton = new JButton();
        cardButton.setBorder(null);
        cardButton.setContentAreaFilled(false);
        BufferedImage cardImage = deckImage.getImage();
        cardButton.addActionListener(this);
        cardButton.setIcon(new ImageIcon(cardImage));

        return cardButton;
    }

    JButton nextTurnButton() {
        JButton nextButton = new JButton();
        nextButton.addActionListener(this);

        return nextButton;
    }

    public void screen() {
        unoScreen.getContentPane().removeAll();
        nextTurn.setBounds(0, 0, getWidth(), getHeight());
        nextTurn.setText(playerArray[currentPlayer - 1] + "'s Turn");
        unoScreen.getContentPane().add(nextTurn);
    }

    public void actionPerformed(ActionEvent e) {
        screen = false;
        hands = Hands.getInstance(numPlayers);
        JButton button = (JButton) e.getSource();
        Hand hand = hands.getHand(currentPlayer);
        int index = 0;
        if (button == deckButton) {
            hand.draw();
        }
        for (Card card : hand.cards) {
            if (card.button == button) {
                boolean playable = hand.playCard(index);
                if (playable) {
                    if (hand.cards.isEmpty()) {
                        playerWon = true;
                    }
                    if (card.symbol.equals("reverse")) {
                        reverse();
                    }
                    nextPlayer();
                    if (card.symbol.equals("skip")) {
                        nextPlayer();
                    }
                    else if (card.symbol.equals("drawTwo")) {
                        drawCards(2);
                    }
                    else if (card.symbol.equals("drawFour")) {
                        drawCards(4);
                    }
                    screen = true;
                    break;
                }
            }
            index++;
        }

        update();
    }

    private void nextPlayer() {
        if (playerWon) {
            win();
        }
        else if (reversed) {
            if (currentPlayer <= 1) {
                currentPlayer = numPlayers;
            }
            else {
                currentPlayer--;
            }
        }
        else {
            if (currentPlayer < numPlayers) {
                currentPlayer++;
            }
            else {
                currentPlayer = 1;
            }
        }
    }

    private void drawCards(int numCards) {
        Hand hand = hands.getHand(currentPlayer);
        for (int i = 0; i < numCards; i++) {
            hand.draw();
        }
    }

    private void reverse() {
        if (reversed) {
            reversed = false;
        }
        else {
            reversed = true;
        }
    }

    public void update() {
        if (playerWon) {
        }
        else if (screen) {
            screen();
        }
        else {
            Discard discard = Discard.getInstance();
            unoScreen.getContentPane().removeAll();
            hands = hands.getInstance(numPlayers);
            hands.drawHand(currentPlayer, deckImage);
            drawDiscard(discard.topCard);
            drawDeck();
            drawPlayers();
        }

        unoScreen.repaint();
    }

    private void win() {
        unoScreen.getContentPane().removeAll();
        JLabel winMessage = new JLabel(playerArray[currentPlayer - 1] + " wins!");
        winMessage.setBounds(halfScreenWidth - 70, halfScreenHeight - 70, 140, 140);
        unoScreen.getContentPane().add(winMessage);
        drawPlayers();
    }
}