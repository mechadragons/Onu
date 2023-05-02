import javax.swing.*;

public class UnoRules {
    public static void main(String[] args) {
        // Set the size of the text area
        int width = 400;
        int height = 300;

        // Create the text area with the rules
        JTextArea textArea = new JTextArea();
        textArea.setText("Uno Rules:\n\n" +
                "1. The game is played with a deck of 108 cards.\n" +
                "2. Each player is dealt 7 cards at the start of the game.\n" +
                "3. The top card of the discard pile is revealed at the beginning of the game.\n" +
                "4. Players take turns to match a card in their hand with the current card on the discard pile.\n" +
                "5. Cards can be matched by number, color, or symbol.\n" +
                "6. If a player doesn't have a matching card, they must draw a card from the deck.\n" +
                "7. Special cards have specific actions: Skip, Reverse, Draw Two, and Wild cards.\n" +
                "8. The first player to get rid of all their cards wins the game.\n\n" +
                "These are the basic rules of Uno. Have fun playing!");

        // Set up the text area
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        // Set the preferred size of the text area
        textArea.setPreferredSize(new java.awt.Dimension(width, height));

        // Create the pop-up message
        JOptionPane.showMessageDialog(null, textArea, "Uno Rules", JOptionPane.INFORMATION_MESSAGE);
    }
}
