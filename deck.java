import java.util.Stack;
import java.util.Collections;

class Deck {
    Stack<Card> cards = new Stack<Card>(); //A stack of the cards in the deck

    public Deck() { //Constructor
        createDeck(); //Generates complete Uno deck
        shuffleDeck(); //Shuffles Uno deck
    }

    void shuffleDeck() {
        Collections.shuffle(cards);
    }

    private void createDeck() { //Generates complete Uno deck
        generateCards("red"); //Generates red cards
        generateCards("yellow"); //Generates yellow cards
        generateCards("blue"); //Generates blue cards
        generateCards("green"); //Generates green cards
        generateWildCards(); //Generates wild and wild draw four cards
    }

    private void generateCards(String color) { //Adds all cards of a given color to cards stack. Called by createDeck
        generateNumberCards(color);
        for (int i = 0; i < 2; i++) {
            cards.push(new Card(color, "skip"));
            cards.push(new Card(color, "reverse"));
            cards.push(new Card(color, "drawTwo"));
        }
    }

    private void generateNumberCards(String color) { //Adds all number cards of a given color to cards stack. Called by generateCards
        for (int symbol = 0; symbol < 10; symbol++) {
            cards.push(new Card(color, Integer.toString(symbol)));
            if (symbol > 0) {
                cards.push(new Card(color, Integer.toString(symbol)));
            }
        }
    }

    private void generateWildCards() { //Adds all wild and wild draw four cards to the cards stack. Called by createDeck
        for (int i = 0; i < 5; i++) {
            cards.push(new Card("wild", "wild"));
            cards.push(new Card("wild", "drawFour"));
        }
    }
}