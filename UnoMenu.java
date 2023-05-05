import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UnoMenu extends JFrame {
    private JButton startButton;
    private JButton rulesButton;
    private JFrame titleScreen;
    private JTextField[] nameFields; // Declare the nameFields array as an instance variable

    public UnoMenu() {
        super("Uno Game Menu");

        // Set up the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Create the main panel
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Create the title panel
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("UNO");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 48));
        titlePanel.add(titleLabel);
        mainPanel.add(titlePanel, BorderLayout.NORTH);

        // Create the button panel
        JPanel buttonPanel = new JPanel();
        startButton = new JButton("Start Game");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openMainMenu();
            }
        });
        buttonPanel.add(startButton);

        rulesButton = new JButton("View Rules");
        rulesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewRules();
            }
        });
        buttonPanel.add(rulesButton);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        add(mainPanel);
    }

    private void viewRules() {
        String rulesText = "UNO Rules:\n" +
                "- The game is played with a deck of cards.\n" +
                "- Each player is dealt 7 cards.\n" +
                "- The first player to get rid of all their cards wins.\n" +
                "- Players take turns playing a card that matches the top card of the discard pile by either number, color, or symbol.\n" +
                "- If a player cannot play a card, they must draw a card from the deck.\n" +
                "- Special cards have unique effects and can be played to disrupt other players' turns.\n" +
                "- When a player has one card remaining, they must call 'UNO'.\n" +
                "- If a player forgets to call 'UNO' and is caught by another player, they must draw 2 cards as a penalty.\n" +
                "- The game continues until a player has no cards left or the deck is empty.\n" +
                "- In case of a tie, the player with the fewest points wins.";
    
        JOptionPane.showMessageDialog(this, rulesText, "UNO Rules", JOptionPane.INFORMATION_MESSAGE);
    }

    private void openMainMenu() {
        JFrame mainMenu = new JFrame("Uno Game Menu");

        // Create the player name panel
        JPanel playerPanel = new JPanel(new GridLayout(8, 1));
        JLabel label = new JLabel("Enter player names:");
        playerPanel.add(label);

        nameFields = new JTextField[8]; // Use the instance variable
        for (int i = 0; i < 8; i++) {
            nameFields[i] = new JTextField(20);
            playerPanel.add(nameFields[i]);
        }
        
        // Create the start button
        JButton startButton = new JButton("Start Game");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
                mainMenu.dispose(); // Close the menu
            }
        });
        playerPanel.add(startButton);
        
        mainMenu.getContentPane().add(playerPanel);
        mainMenu.setSize(300, 400);
        mainMenu.setLocationRelativeTo(null);
        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenu.setVisible(true);
        
        titleScreen.dispose(); // Close the title screen        
    }

    private void startGame() {
        // Get the player names
        ArrayList<String> playerNameList = new ArrayList<>();
        for (JTextField nameField : nameFields) {
            String name = nameField.getText().trim();
            if (!name.isEmpty()) {
                playerNameList.add(name);
            }
        }
    
        // Convert the list to an array
        String[] playerNames = playerNameList.toArray(new String[playerNameList.size()]);
    
        // Validate the player names
        int playerCount = playerNames.length;
        if (playerCount < 2) {
            JOptionPane.showMessageDialog(this, "At least 2 players are required to start the game.");
        } else {
            // Start the Uno game with the provided player names
            GameStart newGame = new GameStart(playerNames);
        }
    }    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                UnoMenu titleScreen = new UnoMenu();
                titleScreen.setVisible(true);
                titleScreen.titleScreen = titleScreen; // Save the reference to the title screen
            }
        });
    }
}