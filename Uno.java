import java.util.ArrayList;
import java.util.Collections;

public class UnoGame {
    private ArrayList<Card> deck;
    private ArrayList<Card> discardPile;
    private ArrayList<Player> players;
    private int currentPlayerIndex;
    private boolean reverse;

    public UnoGame() {
        deck = new ArrayList<Card>();
        discardPile = new ArrayList<Card>();
        players = new ArrayList<Player>();
        currentPlayerIndex = 0;
        reverse = false;

      // Create deck
        for (int i = 0; i < 4; i++) {
         // Create 0 card for each color
            deck.add(new Card(Card.Color.values()[i], Card.Value.ZERO));

         // Create other cards for each color
            for (int j = 1; j < 10; j++) {
                deck.add(new Card(Card.Color.values()[i], Card.Value.values()[j]));
                deck.add(new Card(Card.Color.values()[i], Card.Value.values()[j]));
            }

         // Create action cards for each color
            deck.add(new Card(Card.Color.values()[i], Card.Value.SKIP));
            deck.add(new Card(Card.Color.values()[i], Card.Value.REVERSE));
            deck.add(new Card(Card.Color.values()[i], Card.Value.DRAW_TWO));
        }

      // Create wild cards
        for (int i = 0; i < 4; i++) {
            deck.add(new Card(Card.Color.WILD, Card.Value.WILD));
            deck.add(new Card(Card.Color.WILD, Card.Value.WILD_DRAW_FOUR));
        }

      // Shuffle deck
      Collections.shuffle(deck);
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void shuffleDeck(){
        Collections.shuffle(deck);
    }

    public void dealCards(){
        for(int i = 0; i < 7; i++){
            for(Player player : players){
                Card card = deck.remove(0);
                player.addCard(card);
            }
        }
        Card firstCard = deck.remove(0);
        discardPile.add(firstCard);
    }

    public Card getTopCard(){
        return discradPile.get(discardPile.sie() - 1);
    }

    public void playCard(Card card){
        discardPile.add(Card);
    }

    public boolean canPlayCard(Card card){
        Card topCard = getTopCard();
        return card.isPlayable(topCard, getCurrentPlayer().hetHand());
    }

    public void drawCard(Player player){
        Card card = deck.remove(0);
        player.addCard(card);
    }

    public void startGame() {
      // Deal 7 cards to each player
        for (int i = 0; i < 7; i++) {
            for (Player player : players) {
                player.addCard(deck.remove(0));
            }
        }

      // Place first card on discard pile
        discardPile.add(deck.remove(0));
   }

    public void playCard(Player player, Card card) {
        if (card.isPlayable(discardPile.get(discardPile.size()-1), player.getHand())) {
            player.playCard(card);
            discardPile.add(card);

            if (player.getHand().size() == 0) {
            // Player wins
                System.out.println(player.getName() + " wins!");
                return;
            }

        switch (card.getValue()) {
            case SKIP:
                nextPlayer();
                nextPlayer();
                break;
            case REVERSE:
                reverse = !reverse;
                break;
            case DRAW_TWO:
               nextPlayer().addCard(deck.remove(0));
               nextPlayer().addCard(deck.remove(0));
               break;
            case WILD_DRAW_FOUR:
               nextPlayer().addCard(deck.remove(0));
               nextPlayer().addCard(deck.remove(0));
               nextPlayer().addCard(deck.remove(0));
               nextPlayer().addCard(deck.remove(0));
            case WILD:
               // Do nothing
               break;
            default:
               nextPlayer();
               break;
        }
    }
    else {
        System.out.println("Invalid move");
    }
    }

    private Player nextPlayer() {
        int index = currentPlayerIndex;

        if (reverse) {
            index--;
            if (index < 0) {
            index = players.size() - 1;
            }
        }
        else {
            index++;
            if (index >= players.size()) {
                index = 0;
            }
        }

        currentPlayerIndex = index;
        return players.get(index);
    }

    public void reverseDirection(){
        reverse = !reverse;
    }

    public Player getCurrentPlayer(){
        return players.get(currentPlayerIndex);
    }

    public boolean hasWinner(){
        for(Player player : players){
            if(player.getHand().isEmpty()){
                return true;
            }
        }
        return false;
    }

    public Player getWinner(){
        if(!hasWinner()){
            return null;
        }
    }
    PLayer winner = players.get(0);
    int minScore = winner.getScore();

    for(Player player : players){
        if(!hasWinner()){
            return null;
        }

        PLayer winner = players.get(0);
        int minScore = winner.getScore();

        for(Player player : Players){
            int score = player.getScore();
            if(score < minScore){
                winner = player;
                minScore =score;
            }
        }
        return winner;
    }
}


