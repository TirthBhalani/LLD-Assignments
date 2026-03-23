public abstract class PenDecorator implements IPen {
    protected IPen decoratedPen;

    public PenDecorator(IPen decoratedPen) {
        this.decoratedPen = decoratedPen;
    }

    @Override
    public void write(String text) {
        decoratedPen.write(text);
    }

    @Override
    public void refill(String color) {
        decoratedPen.refill(color);
    }

    @Override
    public void start() {
        decoratedPen.start();
    }

    @Override
    public void close() {
        decoratedPen.close();
    }
}
