class CardTest {
    public static void main(String args[]) {
        CardTest test = new CardTest();
        //test.createCard();
        //test.createDeckTest();
        test.drawHandTest();
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
            System.out.println ("Card color: " + card.color + " // Card symbol: " + card.symbol);
        }
        System.out.println("--------------\nDeck:\n");
        for (Card card : deck.cards) {
            System.out.println ("Card color: " + card.color + " // Card symbol: " + card.symbol);
        }
    }
}