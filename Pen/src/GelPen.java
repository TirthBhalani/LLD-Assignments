public class GelPen extends BasePen {
    public GelPen(String color, OpeningMechanism mechanism) {
        super(color, mechanism);
    }

    @Override
    public void write(String text) {
        validateState();
        System.out.println("GelPen writing (" + ink.getColor() + "): " + text);
        ink.setLevel(ink.getLevel() - 5); 
    }
}
