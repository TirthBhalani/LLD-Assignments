public class ClickMechanism implements OpeningMechanism {
    @Override
    public void open() {
        System.out.println("Click: Nib out.");
    }

    @Override
    public void close() {
        System.out.println("Click: Nib in.");
    }
}
