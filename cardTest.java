class CardTest {
    public static void main(String args[]) {
        CardTest test = new CardTest();
        //test.createCard();
        //test.createDeckTest();
        //test.drawHandTest();
        //test.createDiscardTest();
        //test.topCardTest();
        //test.playCardTest();
        //test.drawTest();
        //test.reshuffleTest();
        //test.GUITest();
        //test.handGenerationTest();
        test.generateHandTest();
        test.drawDiscardTest();
        test.drawDeckTest();
        //test.gameStartTest();
        test.drawPlayersTest();
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

    // void drawHandTest() {
    //     Deck deck = Deck.getInstance();
    //     Hand hand = new Hand();
    //     System.out.println("Hand:");
    //     for (Card card : hand.cards) {
    //         System.out.println("Card color: " + card.color + " // Card symbol: " + card.symbol);
    //     }
    //     System.out.println("--------------\nDeck:\n");
    //     for (Card card : deck.cards) {
    //         System.out.println("Card color: " + card.color + " // Card symbol: " + card.symbol);
    //     }
    // }

    void createDiscardTest() {
        Deck deck = Deck.getInstance();
        Discard discard = Discard.getInstance();
        System.out.println("Discard:");
        for (Card card : discard.cards) {
            System.out.println("Card color: " + card.color + " // Card symbol: " + card.symbol);
        }
        System.out.println("--------------\nDeck:");
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

    // void playCardTest() {
    //     Hand hand = new Hand();
    //     Discard discard = Discard.getInstance();
    //     System.out.println("Hand:");
    //     for (Card card : hand.cards) {
    //         System.out.println("Card color: " + card.color + " // Card symbol: " + card.symbol);
    //     }
    //     System.out.println("Top card: ");
    //     System.out.println("Card color: " + discard.topCard.color + " // Card symbol: " + discard.topCard.symbol);
    //     System.out.println("--------------");
    //     hand.playCard(0);
    // }

    // void drawTest() {
    //     Deck deck = Deck.getInstance();
    //     Hand hand = new Hand();
    //     while (!deck.cards.isEmpty()) {
    //         hand.draw();
    //     }
    //     System.out.println("Hand:");
    //     for (Card card : hand.cards) {
    //         System.out.println("Card color: " + card.color + " // Card symbol: " + card.symbol);
    //     }
    // }

    void reshuffleTest() {
        Deck deck = Deck.getInstance();
        Hand hand = new Hand();
        Discard discard = Discard.getInstance();
        while (!deck.cards.isEmpty()) {
            hand.draw();
        }
        for (int i = 0; i < hand.cards.size(); i++) {
            hand.playCard(i);
        }
        System.out.println("Deck, before shuffling:");
        for (Card card : deck.cards) {
            System.out.println("Card color: " + card.color + " // Card symbol: " + card.symbol);
        }
        System.out.println("Discard, before shuffling:");
        for (Card card : discard.cards) {
            System.out.println("Card color: " + card.color + " // Card symbol: " + card.symbol);
        }
        System.out.println("Top card of discard, before shuffling:");
        System.out.println("Card color: " + discard.topCard.color + " // Card symbol: " + discard.topCard.symbol);
        System.out.println("-----------------");
        discard.reshuffle();
        System.out.println("Deck, after shuffling:");
        for (Card card : deck.cards) {
            System.out.println("Card color: " + card.color + " // Card symbol: " + card.symbol);
        }
        System.out.println("Discard, after shuffling:");
        for (Card card : discard.cards) {
            System.out.println("Card color: " + card.color + " // Card symbol: " + card.symbol);
        }
        System.out.println("Top card of discard, after shuffling:");
        System.out.println("Card color: " + discard.topCard.color + " // Card symbol: " + discard.topCard.symbol);
    }

    void GUITest() {
        Deck deck = Deck.getInstance();
        GUI gui = GUI.getInstance();
        gui.drawCard(deck.cards.peek(), 0, 0);
    }

    // void handGenerationTest() {
    //     Hands gameStart = Hands.getInstance(3);
    //     for (Hand hand : gameStart.hands) {
    //         System.out.println("{");
    //         for (Card card : hand.cards) {
    //             System.out.print(card.color + " " + card.symbol + ", ");
    //         }
    //         System.out.print("}");
    //     }
    // }

    void generateHandTest() {
        Hands hands = Hands.getInstance(3);
        DeckImage deckImage = new DeckImage("cards.png");
        hands.getHand(1).draw();
        hands.getHand(1).draw();
        hands.getHand(1).draw();
        hands.getHand(1).draw();
        hands.getHand(1).draw();
        hands.getHand(1).draw();
        hands.getHand(1).draw();
        hands.getHand(1).draw();
        hands.getHand(1).draw();
        hands.getHand(1).draw();
        hands.getHand(1).draw();
        hands.getHand(1).draw();
        hands.getHand(1).draw();
        hands.drawHand(1, deckImage);
    }

    void drawDiscardTest() {
        Discard discard = Discard.getInstance();
    }

    void drawDeckTest() {
        Deck deck = Deck.getInstance();
    }

    void gameStartTest() {
        GameStart gameStart = new GameStart(3);
    }

    void drawPlayersTest() {
        GUI gui = GUI.getInstance();
        String[] players = {"player1", "player2", "player3", "player4", "player5", "player6", "player7", "player8"};
        gui.drawPlayers(players);
    }
}