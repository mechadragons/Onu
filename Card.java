import java.util.ArrayList;
import java.util.Collections;

public enum CardColor{
    RED, BLUE, YELLOW, GREEN, WILD
}

public enum CardValue{
    ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, SKIP, REVERSE, DRAW_TWO, WILD, WILD_DRAW_FOUR
}

public class Card {
    private CardColor color;
    private CardValue value;

    public Card(CardColor color, CardValue value){
        this.color = color;
        this.value = value;
    }

    public CardColor getColor(){
        return color;
    }

    public CardValue getValue(){
        return value;
    }

    public boolean isPlayable(Card topCard, List<Card> hand){
        if(this.color == CardColor.WILD || this.color == topCard.getColor() || this.value == topCard.getValue()){
            return true;
        }
        for(Card card : hand){
            if(card.getColor() == topCard.getColor() || card.getValue() == topCard.getValue()){
                return false;
            }
        }
        return true;
    }
}