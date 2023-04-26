import java.util.ArrayList;

class Hand {
    ArrayList<Card> cards = new ArrayList<Card>();
    Deck deck = Deck.getInstance();

    public Hand() {
        drawStartingHand();
    }

    void draw() {
        cards.add(deck.cards.peek());
        deck.cards.pop();
    }

    void drawStartingHand() {
        for (int i = 0; i < 7; i++) {
            draw();
        }
    }
}