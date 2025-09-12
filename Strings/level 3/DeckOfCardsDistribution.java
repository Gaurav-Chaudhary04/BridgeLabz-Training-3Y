import java.util.Scanner;

public class DeckOfCardsDistribution {

    static String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    static String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    // Initialize deck of cards
    public static String[] initializeDeck() {
        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];
        int index = 0;
        for(String suit : suits) {
            for(String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    // Shuffle deck of cards
    public static void shuffleDeck(String[] deck) {
        int n = deck.length;
        for(int i=0; i<n; i++) {
            int randomCardNumber = i + (int)(Math.random() * (n - i));
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
    }

    // Distribute n cards to x players - returns 2D array [player][cards]
    public static String[][] distributeCards(String[] deck, int n, int x) {
        if(n > deck.length || (n % x) != 0) return null;
        String[][] players = new String[x][n/x];
        int cardIndex = 0;
        for(int i=0; i<n/x; i++) {
            for(int j=0; j<x; j++) {
                players[j][i] = deck[cardIndex++];
            }
        }
        return players;
    }

    // Print players and their cards
    public static void printPlayersCards(String[][] players) {
        for(int i=0; i<players.length; i++) {
            System.out.println("Player " + (i+1) + ":");
            for(String card : players[i]) {
                System.out.println("	" + card);
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] deck = initializeDeck();
        shuffleDeck(deck);

        System.out.print("Enter number of cards to distribute: ");
        int n = sc.nextInt();

        System.out.print("Enter number of players: ");
        int x = sc.nextInt();

        String[][] players = distributeCards(deck, n, x);

        if(players == null) {
            System.out.println("Cannot distribute cards evenly to players.");
        } else {
            printPlayersCards(players);
        }
    }
}
