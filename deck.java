import java.util.Stack;

class Deck {
    Stack<Card> cards = new Stack<Card>(); //A stack of the cards in the deck

    public Deck() { //Constructor
        createDeck(cards); //Generates complete Uno deck
    }

    private void createDeck(Stack<Card> cards) { //Generates complete Uno deck
        generateCards(cards, "red"); //Generates red cards
        generateCards(cards, "yellow"); //Generates yellow cards
        generateCards(cards, "blue"); //Generates blue cards
        generateCards(cards, "green"); //Generates green cards
        generateWildCards(cards); //Generates wild and wild draw four cards
    }

    private void generateCards(Stack<Card> cards, String color) { //Adds all cards of a given color to cards stack. Called by createDeck
        generateNumberCards(cards, color);
        for (int i = 0; i < 2; i++) {
            cards.push(new Card(color, "skip"));
            cards.push(new Card(color, "reverse"));
            cards.push(new Card(color, "drawTwo"));
        }
    }

    private void generateNumberCards(Stack<Card> cards, String color) { //Adds all number cards of a given color to cards stack. Called by generateCards
        for (int symbol = 0; symbol < 10; symbol++) {
            cards.push(new Card(color, Integer.toString(symbol)));
            if (symbol > 0) {
                cards.push(new Card(color, Integer.toString(symbol)));
            }
        }
    }

    private void generateWildCards(Stack<Card> cards) { //Adds all wild and wild draw four cards to the cards stack. Called by createDeck
        for (int i = 0; i < 5; i++) {
            cards.push(new Card("wild", "wild"));
            cards.push(new Card("wild", "drawFour"));
        }
    }
}