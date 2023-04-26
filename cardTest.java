class CardTest {
    public static void main(String args[]) {
        CardTest test = new CardTest();
        test.createCard();
    }

    void createCard() {
        Card testCard = new Card("red", "7");
        System.out.println("Card color: " + testCard.color + " (should be red)");
        System.out.println("Card symbol: " + testCard.symbol + " (should be 7)");
    }
}