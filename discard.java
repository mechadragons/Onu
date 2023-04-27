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

    private void drawStartingCard() {
        while (deck.cards.peek().color == "wild") {
            deck.shuffleDeck();
        }
        topCard = deck.cards.peek();
        cards.push(deck.cards.peek());
        deck.cards.pop();
    }
}