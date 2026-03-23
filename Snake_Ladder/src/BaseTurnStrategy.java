public abstract class BaseTurnStrategy implements ITurnStrategy {
    protected void movePlayer(Player player, int roll, Board board) {
        int targetPosition = player.getPosition() + roll;
        
        if (targetPosition > board.getSize()) {
            System.out.println("Overshot the board. Needs exactly " + (board.getSize() - player.getPosition()) + " to win.");
            return;
        }
        
        System.out.println("Moves to " + targetPosition);
        int finalPosition = board.getFinalPosition(targetPosition);
        player.setPosition(finalPosition);
    }
}
