public class ExternalPanel {
private int floorNumber;

public ExternalPanel(int floorNumber) {
    this.floorNumber = floorNumber;
}

public void pressUp() {
    ElevatorSystem.getInstance().requestElevator(floorNumber, Direction.UP);
}

public void pressDown() {
    ElevatorSystem.getInstance().requestElevator(floorNumber, Direction.DOWN);
}
}
