import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Uno!");

        Deck deck = new Deck();
        deck.shuffle();

        List<Player> players = new ArrayList<>();
        System.out.print("Enter the number of players: ");
        int numPlayers = scanner.nextInt();
        for(int i = 1; i <= numPlayers; i++){
            System.out.print("Enter the name of players " + i + ": ");
            String playerName = scanner.next();
            Player player = new player(playerName);
            player.drawCards(deck, 7);
            players.add(player);
        }

        Card topCard = deck.raw();
        Discard discard = new Discard(topCard);
        
        gameStart game = new gameStart(players, drawPile, discard);
        gameStart.play();
    }
}