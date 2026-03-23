public class GripDecorator extends PenDecorator {
    public GripDecorator(IPen decoratedPen) {
        super(decoratedPen);
    }

    @Override
    public void write(String text) {
        System.out.println("[Grip attached] Holding pen tightly...");
        super.write(text);
    }
}
