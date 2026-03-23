import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Board {
    private int size;
    private Map<Integer, Jumper> snakes;
    private Map<Integer, Jumper> ladders;

    public Board(int n) {
        this.size = n * n;
        this.snakes = new HashMap<>();
        this.ladders = new HashMap<>();
        generateJumpers(n);
    }

    public int getSize() {
        return size;
    }

    public int getFinalPosition(int position) {
        if (snakes.containsKey(position)) {
            System.out.println("Bitten by snake at " + position + ". Sliding down to " + snakes.get(position).getEndPoint());
            return snakes.get(position).getEndPoint();
        }
        if (ladders.containsKey(position)) {
            System.out.println("Climbed ladder at " + position + ". Moving up to " + ladders.get(position).getEndPoint());
            return ladders.get(position).getEndPoint();
        }
        return position;
    }

    private void generateJumpers(int count) {
        Set<Integer> usedCells = new HashSet<>();
        Random rand = new Random();
        
        int snakesCreated = 0;
        while (snakesCreated < count) {
            int head = rand.nextInt(size - 2) + 2;
            int tail = rand.nextInt(head - 1) + 1;
            
            if (!usedCells.contains(head) && !usedCells.contains(tail)) {
                snakes.put(head, new Jumper(head, tail));
                usedCells.add(head);
                usedCells.add(tail);
                snakesCreated++;
            }
        }
        
        int laddersCreated = 0;
        while (laddersCreated < count) {
            int start = rand.nextInt(size - 2) + 2;
            int end = start + 1 + rand.nextInt(size - start);
            
            if (end > size) {
                end = size;
            }
            
            if (!usedCells.contains(start) && !usedCells.contains(end) && start != end) {
                ladders.put(start, new Jumper(start, end));
                usedCells.add(start);
                usedCells.add(end);
                laddersCreated++;
            }
        }
    }
}
