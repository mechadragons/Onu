class CardTest {
    public static void main(String args[]) {
        //CardTest test = new CardTest();
        //test.createCard();
        //test.createDeckTest();
        //test.drawHandTest();
        //test.createDiscardTest();
        //test.topCardTest();
        //test.playCardTest();
    }

    void createCard() {
        Card testCard = new Card("red", "7");
        System.out.println("Card color: " + testCard.color + " (should be red)");
        System.out.println("Card symbol: " + testCard.symbol + " (should be 7)");
    }

    void createDeckTest() {
        Deck deck = Deck.getInstance();
        for (Card card : deck.cards) {
            System.out.println("Card color: " + card.color + " // Card symbol: " + card.symbol);
        }
    }

    void drawHandTest() {
        Deck deck = Deck.getInstance();
        Hand hand = new Hand();
        System.out.println("Hand:\n");
        for (Card card : hand.cards) {
            System.out.println("Card color: " + card.color + " // Card symbol: " + card.symbol);
        }
        System.out.println("--------------\nDeck:\n");
        for (Card card : deck.cards) {
            System.out.println("Card color: " + card.color + " // Card symbol: " + card.symbol);
        }
    }

    void createDiscardTest() {
        Deck deck = Deck.getInstance();
        Discard discard = Discard.getInstance();
        System.out.println("Discard:\n");
        for (Card card : discard.cards) {
            System.out.println("Card color: " + card.color + " // Card symbol: " + card.symbol);
        }
        System.out.println("--------------\nDeck:\n");
        for (Card card : deck.cards) {
            System.out.println("Card color: " + card.color + " // Card symbol: " + card.symbol);
        }
    }

    void topCardTest() {
        Discard discard = Discard.getInstance();
        for (Card card : discard.cards) {
            System.out.println("Card color: " + card.color + " // Card symbol: " + card.symbol);
        }
        System.out.println("\nCard color: " + discard.topCard.color + " // Card symbol: " + discard.topCard.symbol);
        System.out.println("\nThe above two lines should be the same");
    }

    void playCardTest() {
        Hand hand = new Hand();
        Discard discard = Discard.getInstance();
        System.out.println("Hand:\n");
        for (Card card : hand.cards) {
            System.out.println("Card color: " + card.color + " // Card symbol: " + card.symbol);
        }
        System.out.println("Top card: ");
        System.out.println("Card color: " + discard.topCard.color + " // Card symbol: " + discard.topCard.symbol);
        System.out.println("--------------");
        hand.playCard(0);
    }
}