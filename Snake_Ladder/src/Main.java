import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter board size (n for nxn): ");
        int n = scanner.nextInt();
        
        System.out.print("Enter number of players: ");
        int playerCount = scanner.nextInt();
        
        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= playerCount; i++) {
            players.add(new Player("Player " + i));
        }
        
        System.out.print("Enter difficulty (1 for Easy, 2 for Hard): ");
        int diffChoice = scanner.nextInt();
        
        ITurnStrategy strategy;
        if (diffChoice == 2) {
            strategy = new HardTurnStrategy();
        } else {
            strategy = new EasyTurnStrategy();
        }
        
        Game game = new Game(n, players, new StandardDice(6), strategy);
        game.play();
        
        scanner.close();
    }
}
