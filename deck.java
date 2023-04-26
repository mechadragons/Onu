import java.util.Stack;

class Deck {
    Stack<Card> cards = new Stack<Card>();

    public Deck() {
        createDeck(cards);
    }

    void createDeck(Stack<Card> cards) {
        generateNumberCards(cards, "red");
    }

    private void generateNumberCards(Stack<Card> cards, String color) {
        for (int symbol = 0; symbol < 10; symbol++) {
            cards.push(new Card(color, Integer.toString(symbol)));
            if (symbol > 0) {
                cards.push(new Card(color, Integer.toString(symbol)));
            }
        }
    }
}