import java.lang.Math;

public class Hands {
    Hand[] hands;

    Hands(int numPlayers) {
        hands = new Hand[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            hands[i] = new Hand();
        }
    }

    public Hand getHand(int player) {
        return hands[player - 1];
    }

    public void drawHand(int player, DeckImage deckImage, GUI gui) {
        Hand hand = hands[player - 1];
        int handLength = hand.getLength();
        int cardWidth = deckImage.getWidth();
        int handWidth = cardWidth * handLength;
        int screenWidth = gui.getWidth();
        int margins = screenWidth - handWidth;
        int margin = 20;
        int numMargins = handLength - 1;
        int pos = 0;
        if (margins >= 0) {
            if (handWidth + margin * numMargins > screenWidth) {
                margin = (int) Math.ceil((double) margins / (double) numMargins);
            }
            pos = (margins - margin * numMargins) / 2;
            margin += cardWidth;
        }
        else {
            margins = handWidth - screenWidth;
            margin = cardWidth - (int) Math.ceil((double) margins / (double) numMargins);
        }
        for (int i = 0; i < handLength; i++) {
            gui.drawCard(hand.getCard(i), pos, 50);
            pos += margin;
        }
    }
}