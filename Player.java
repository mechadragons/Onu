import java.util.ArrayList;
import java.util.Collections;

public class PLayer{
    private String name;
    private List<Card> hand;

    public Player(string name){
        this.name = name;
        this.hand = new ArrayList<>();
    }
    public String getName(){
        return name;
    }

    public List<Card> gethand(){
        return hand;
    }

    public void addCard(Card card){
        hand.add(card);
    }

    public void removeCard(Card card){
        hand.remove(card);
    }

    public void playCard(Card card){
        removeCard(card);
    }

    public int getScore(){
        int score = 0;
        for(Card card : hnad){
            score += card.getValue().ordinal();
        }
        return score; 
    }
}