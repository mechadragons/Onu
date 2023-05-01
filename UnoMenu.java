import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnoMenu extends JFrame {
    private JTextField[] nameFields;
    private JButton startButton;

    public UnoMenu() {
        super("Uno Game Menu");

        // Set up the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        // Create the main panel
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Create the player name panel
        JPanel playerPanel = new JPanel(new GridLayout(9, 1));
        JLabel label = new JLabel("Enter player names:");
        playerPanel.add(label);

        nameFields = new JTextField[8];
        for (int i = 0; i < 8; i++) {
            nameFields[i] = new JTextField(20);
            playerPanel.add(nameFields[i]);
        }
        mainPanel.add(playerPanel, BorderLayout.CENTER);

        // Create the start button
        startButton = new JButton("Start Game");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });
        mainPanel.add(startButton, BorderLayout.SOUTH);

        // Add the main panel to the frame
        getContentPane().add(mainPanel);

        // Pack and set the frame visible
        pack();
        setVisible(true);
    }

    private void startGame() {
        // Get the player names
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
            // Start the Uno game with the provided player names
            // UnoGame unoGame = new UnoGame(playerNames);
            // unoGame.start();
            // dispose(); // Close the menu
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                UnoMenu menu = new UnoMenu();
            }
        });
    }
}
