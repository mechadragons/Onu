import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnoMenu extends JFrame {
    private JButton startButton;
    private JButton rulesButton;
    private JFrame titleScreen;

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
        // UnoRulesPopUp.main(new String[0]);
    }

    private void openMainMenu() {
        JFrame mainMenu = new JFrame("Uno Game Menu");

        // Create the player name panel
        JPanel playerPanel = new JPanel(new GridLayout(8, 1));
        JLabel label = new JLabel("Enter player names:");
        playerPanel.add(label);

        JTextField[] nameFields = new JTextField[8];
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
        JFrame mainMenu = new JFrame("Uno Game Menu");
        JTextField[] nameFields = new JTextField[8];
        for (int i = 0; i < 8; i++) {
            nameFields[i] = new JTextField(20);
        }

        String[] playerNames = new String[8];
        for (int i = 0; i < 8; i++) {
            playerNames[i] = nameFields[i].getText().trim();
        }

        // Validate the player names
        int playerCount = 0;
        for (String name : playerNames) {
            if (!name.isEmpty()) {
                playerCount++;
            }
        }

        if (playerCount < 2) {
            JOptionPane.showMessageDialog(this, "At least 2 players are required to start the game.");
        } else {
            GameStart gameStart = new GameStart(playerNames); // Start the Uno game with the provided player names
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

