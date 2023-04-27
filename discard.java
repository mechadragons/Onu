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

    void reshuffle() {
        cards.pop(); //The topCard is NOT the top card of the discard stack. But since said card is stored in topCard it can be added back in after being popped, without (incorrectly) shuffling it back into the deck.
        while (!cards.isEmpty()) {
            deck.cards.push(cards.peek());
            cards.pop();
        }
        cards.push(topCard);
        deck.shuffleDeck();
    }

    private void drawStartingCard() {
        while (deck.cards.peek().color == "wild") {
            deck.shuffleDeck();
        }
        addCard(deck.cards.peek());
        deck.cards.pop();
    }
}