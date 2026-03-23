public class Main {
    public static void main(String[] args) {
        IPen ballPen = new BallPen("Blue", new ClickMechanism());
        ballPen.start();
        ballPen.write("Testing normal ball pen.");
        ballPen.close();
        
        System.out.println();

        IPen gelPenWithGrip = new GripDecorator(new GelPen("Black", new CapMechanism()));
        gelPenWithGrip.start();
        gelPenWithGrip.write("Testing gel pen with a grip.");
        gelPenWithGrip.refill("Red");
        gelPenWithGrip.write("Writing after refill.");
        gelPenWithGrip.close();
    }
}
