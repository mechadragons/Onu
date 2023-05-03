import javax.swing.JButton;

class Card {
    String color;
    String symbol;
    JButton button;
    GUI gui;

    Card(String color, String symbol) {
        this.color = color;
        this.symbol = symbol;
        gui = GUI.getInstance();
        this.button = gui.newButton(this);
    }
}