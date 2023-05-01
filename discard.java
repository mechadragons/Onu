import java.util.Stack;

class Discard {
    private static Discard instance;
    Stack<Card> cards = new Stack<Card>(); //A stack of cards in the discard pile. These will not be in the correct order, as only the top card matters
    Deck deck = Deck.getInstance();
    GUI gui = GUI.getInstance();
    Card topCard; //The card on top of the discard pile

    private Discard() { //Discard is a singleton
        drawStartingCard(); //Automatically draws the first card to start the discard pile
    }

    public static Discard getInstance() { //Returns a discard pile
        if (instance == null) {
            instance = new Discard();
        }
        return instance;
    }

    void addCard(Card card) { //Takes a card and adds it to the "top" of the discard pile
        topCard = card;
        cards.push(card);
        gui.drawDiscard(topCard);
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

    private void drawStartingCard() { //Draws the first card to start the discard pile. Private, called by the instructor
        while (deck.cards.peek().color == "wild") {
            deck.shuffleDeck();
        }
        addCard(deck.cards.peek());
        deck.cards.pop();
    }
}