import java.util.ArrayList;

class Hand {
    ArrayList<Card> cards = new ArrayList<Card>(); //An ArrayList of cards in a hand
    Deck deck = Deck.getInstance();
    Discard discard = Discard.getInstance();

    public Hand() {
        drawStartingHand(); //Automatically draws initial hand when constructed
    }

    void draw() { //Draws a card into the hand. Automatically reshuffles the deck if the deck is empty.
        if (deck.cards.isEmpty()) {
            discard.reshuffle();
        }
        cards.add(deck.cards.peek());
        deck.cards.pop();
    }

    void playCard(int index) { //Takes in an index of a card in the hand, and attempts to play the card at that index. If it does not match, a message stating such will be printed instead.
        Card card = cards.get(index);
        if (card.color == "wild" || card.color == discard.topCard.color) {
            discard.addCard(card);
            cards.remove(index);
        }
        else {
            System.out.println("That card does not have a matching color or symbol!");
        }
    }

    private void drawStartingHand() { //Draws the starting hand of cards. Private, as the constructor does this automatically
        for (int i = 0; i < 7; i++) {
            draw();
        }
    }

    public int getLength() {
        return cards.size();
    }

    public Card getCard(int index) {
        return cards.get(index);
    }
}