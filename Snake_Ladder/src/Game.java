import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {
    private Board board;
    private Queue<Player> players;
    private List<Player> winners;
    private IDice dice;
    private ITurnStrategy turnStrategy;

    public Game(int boardSize, List<Player> playerList, IDice dice, ITurnStrategy turnStrategy) {
        this.board = new Board(boardSize);
        this.players = new LinkedList<>(playerList);
        this.winners = new ArrayList<>();
        this.dice = dice;
        this.turnStrategy = turnStrategy;
    }

    public void play() {
        System.out.println("Game Started");
        
        while (players.size() > 1) {
            Player currentPlayer = players.poll();
            System.out.println("\n" + currentPlayer.getName() + "'s turn. Current Position: " + currentPlayer.getPosition());
            
            turnStrategy.playTurn(currentPlayer, dice, board);

            if (currentPlayer.getPosition() == board.getSize()) {
                System.out.println(currentPlayer.getName() + " has finished the game.");
                winners.add(currentPlayer);
            } else {
                players.add(currentPlayer);
            }
        }
        
        System.out.println("\nFinal Standings:");
        for (int i = 0; i < winners.size(); i++) {
            System.out.println((i + 1) + ". " + winners.get(i).getName());
        }
    }
}
