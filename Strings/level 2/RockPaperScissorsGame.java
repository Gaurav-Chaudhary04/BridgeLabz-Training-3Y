import java.util.Scanner;

public class RockPaperScissorsGame {

    public static String getComputerChoice() {
        int choice = (int)(Math.random() * 3);
        switch(choice) {
            case 0: return "rock";
            case 1: return "paper";
            default: return "scissors";
        }
    }

    public static String findWinner(String userChoice, String computerChoice) {
        if(userChoice.equals(computerChoice)) return "Draw";
        if(userChoice.equals("rock") && computerChoice.equals("scissors")) return "User";
        if(userChoice.equals("paper") && computerChoice.equals("rock")) return "User";
        if(userChoice.equals("scissors") && computerChoice.equals("paper")) return "User";
        return "Computer";
    }

    public static String[][] calculateWinStats(String[] winners, int totalGames) {
        int userWins = 0, compWins = 0, draws = 0;
        for(String w : winners) {
            if(w.equals("User")) userWins++;
            else if(w.equals("Computer")) compWins++;
            else draws++;
        }
        double userPercent = 100.0 * userWins / totalGames;
        double compPercent = 100.0 * compWins / totalGames;
        double drawPercent = 100.0 * draws / totalGames;

        String[][] stats = {
            {"User", String.valueOf(userWins), String.format("%.2f", userPercent)},
            {"Computer", String.valueOf(compWins), String.format("%.2f", compPercent)},
            {"Draw", String.valueOf(draws), String.format("%.2f", drawPercent)}
        };
        return stats;
    }

    public static void displayResults(String[] winners, String[][] stats) {
        System.out.println("Game	Winner");
        for(int i=0; i<winners.length; i++) {
            System.out.println((i+1) + "	" + winners[i]);
        }
        System.out.println("
Summary:");
        System.out.println("Player	Wins	Percentage");
        for(String[] row : stats) {
            System.out.println(row[0] + "	" + row[1] + "	" + row[2] + "%");
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of games: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] winners = new String[n];

        for(int i = 0; i < n; i++) {
            System.out.print("Enter your choice (rock/paper/scissors) for game " + (i+1) + ": ");
            String userChoice = sc.nextLine().toLowerCase();
            String computerChoice = getComputerChoice();
            String winner = findWinner(userChoice, computerChoice);
            winners[i] = winner;
            System.out.println("Computer choice: " + computerChoice + ", Winner: " + winner);
        }

        String[][] stats = calculateWinStats(winners, n);
        displayResults(winners, stats);
    }
}
