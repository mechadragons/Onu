public class GameStart {
    Hand[] hands;

    GameStart(int numPlayers) {
        hands = new Hand[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            hands[i] = new Hand();
        }
    }
}