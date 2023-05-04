public class GameStart {
    int numPlayers;
    GUI gui;
    Discard discard;
    Hands hands;

    GameStart(String[] players) {
        int numPlayers = players.length;
        hands = Hands.getInstance(numPlayers);
        gui = GUI.getInstance();
        discard = Discard.getInstance();
        
        gui.drawPlayers(players);
        
        DeckImage deckImage = new DeckImage("cards.png");
        hands.drawHand(1, deckImage);
    }
}