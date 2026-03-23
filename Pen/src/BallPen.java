public class BallPen extends BasePen {
    public BallPen(String color, OpeningMechanism mechanism) {
        super(color, mechanism);
    }

    @Override
    public void write(String text) {
        validateState();
        System.out.println("BallPen writing (" + ink.getColor() + "): " + text);
        ink.setLevel(ink.getLevel() - 2); 
    }
}
