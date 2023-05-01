public class GameStart {
    Discard discard;
    Hands hands;

    GameStart(int numPlayers) {
        discard = Discard.getInstance();
        hands = new Hands(numPlayers);
    }
}