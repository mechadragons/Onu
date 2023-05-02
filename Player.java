import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public void removeCard(Card card) {
        hand.remove(card);
    }

    public void playCard(Card card) {
        if (hand.contains(card)) {
            hand.remove(card);
        }
    }

    public void drawCard(Deck deck) {
        Card card = deck.draw();
        hand.add(card);
    }
}
