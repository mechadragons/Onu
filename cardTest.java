class CardTest {
    public static void main(String args[]) {
        CardTest test = new CardTest();
        //test.createCard();
        //test.createDeckTest();
        Deck deck = new Deck();
    }

    void createCard() {
        Card testCard = new Card("red", "7");
        System.out.println("Card color: " + testCard.color + " (should be red)");
        System.out.println("Card symbol: " + testCard.symbol + " (should be 7)");
    }

    void createDeckTest() {
        Deck deck = new Deck();
        for (Card card : deck.cards) {
            System.out.println("Card color: " + card.color + " // Card symbol: " + card.symbol);
        }
    }
}