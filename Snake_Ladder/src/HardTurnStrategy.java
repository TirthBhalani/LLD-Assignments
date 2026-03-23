public class HardTurnStrategy extends BaseTurnStrategy {
    private int penaltyThreshold = 3;

    public void playTurn(Player player, IDice dice, Board board) {
        int initialPosition = player.getPosition();
        int consecutiveSixes = 0;

        while (true) {
            int roll = dice.roll();
            System.out.println(player.getName() + " rolled a " + roll);

            if (roll == 6) {
                consecutiveSixes++;
                
                if (consecutiveSixes == penaltyThreshold) {
                    System.out.println("Hard mode penalty. Three 6s rolled. Resetting to start of turn.");
                    player.setPosition(initialPosition);
                    break;
                }
                
                movePlayer(player, roll, board);
                
                if (player.getPosition() == board.getSize()) {
                    break;
                }
                
                System.out.println(player.getName() + " gets an extra turn.");
            } else {
                movePlayer(player, roll, board);
                break;
            }
        }
    }
}
