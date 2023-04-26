import java.util.Stack;

class Deck {
    Stack<Card> cards = new Stack<Card>();

    public Deck() {
        createDeck(cards);
    }

    private void createDeck(Stack<Card> cards) {
        generateCards(cards, "red");
        generateCards(cards, "yellow");
        generateCards(cards, "blue");
        generateCards(cards, "green");
        generateWildCards(cards);
    }

    private void generateCards(Stack<Card> cards, String color) {
        generateNumberCards(cards, color);
        for (int i = 0; i < 2; i++) {
            cards.push(new Card(color, "skip"));
            cards.push(new Card(color, "reverse"));
            cards.push(new Card(color, "drawTwo"));
        }
    }

    private void generateNumberCards(Stack<Card> cards, String color) {
        for (int symbol = 0; symbol < 10; symbol++) {
            cards.push(new Card(color, Integer.toString(symbol)));
            if (symbol > 0) {
                cards.push(new Card(color, Integer.toString(symbol)));
            }
        }
    }

    private void generateWildCards(Stack<Card> cards) {
        for (int i = 0; i < 5; i++) {
            cards.push(new Card("wild", "wild"));
            cards.push(new Card("wild", "drawFour"));
        }
    }
}