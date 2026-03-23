public abstract class BasePen implements IPen {
    protected Ink ink;
    protected OpeningMechanism mechanism;
    protected boolean isOpen;

    public BasePen(String color, OpeningMechanism mechanism) {
        this.ink = new Ink(color);
        this.mechanism = mechanism;
        this.isOpen = false;
    }

    @Override
    public void start() {
        mechanism.open();
        isOpen = true;
    }

    @Override
    public void close() {
        mechanism.close();
        isOpen = false;
    }

    @Override
    public void refill(String color) {
        ink.setColor(color);
        ink.setLevel(100);
        System.out.println("Refill done. 100% " + color + " ink.");
    }

    protected void validateState() {
        if (!isOpen) {
            throw new IllegalStateException("Start the pen first.");
        }
        if (ink.getLevel() <= 0) {
            throw new IllegalStateException("Ink empty. Needs refill.");
        }
    }
}
