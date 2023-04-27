import java.util.Stack;

class Discard {
    private static Discard instance;
    Stack<Card> cards = new Stack<Card>();
    Deck deck = Deck.getInstance();
    Card topCard;

    private Discard() { //Discard is a singleton
        drawStartingCard();
    }

    public static Discard getInstance() {
        if (instance == null) {
            instance = new Discard();
        }
        return instance;
    }

    void addCard(Card card) {
        topCard = card;
        cards.push(card);
    }

    private void drawStartingCard() {
        while (deck.cards.peek().color == "wild") {
            deck.shuffleDeck();
        }
        addCard(deck.cards.peek());
        deck.cards.pop();
    }
}