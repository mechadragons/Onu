import java.util.ArrayList;

class Hand {
    ArrayList<Card> cards = new ArrayList<Card>();
    Deck deck = Deck.getInstance();
    Discard discard = Discard.getInstance();

    public Hand() {
        drawStartingHand();
    }

    void draw() {
        cards.add(deck.cards.peek());
        deck.cards.pop();
    }

    void playCard(int index) {
        Card card = cards.get(index);
        if (card.color == "wild" || card.color == discard.topCard.color) {
            discard.addCard(card);
            cards.remove(index);
        }
        else {
            System.out.println("That card does not have a matching color or symbol!");
        }
    }

    private void drawStartingHand() {
        for (int i = 0; i < 7; i++) {
            draw();
        }
    }
}