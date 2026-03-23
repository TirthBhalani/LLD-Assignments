public class EasyTurnStrategy extends BaseTurnStrategy {
    public void playTurn(Player player, IDice dice, Board board) {
        while (true) {
            int roll = dice.roll();
            System.out.println(player.getName() + " rolled a " + roll);
            
            movePlayer(player, roll, board);
            
            if (player.getPosition() == board.getSize() || roll != 6) {
                break;
            }
            
            System.out.println(player.getName() + " gets an extra turn.");
        }
    }
}
