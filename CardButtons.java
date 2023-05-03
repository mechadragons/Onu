import javax.swing.JButton;
import java.util.ArrayList;

public class CardButtons {
    ArrayList<JButton> buttons;

    public CardButtons() {
        buttons = new ArrayList<JButton>();
    }

    public void addButton(JButton button) {
        buttons.add(button);
    }

    public void removeButton(int index) {
        buttons.remove(index);
    }

    public int getIndex(JButton button) {
        return buttons.indexOf(button);
    }
}