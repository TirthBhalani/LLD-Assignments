public class InternalPanel {
private int carId;
private ElevatorCar car;

public InternalPanel(int carId, ElevatorCar car) {
    this.carId = carId;
    this.car = car;
}

public void pressFloor(int floor) {
    car.move(floor);
}

public void pressOpen() {
    car.openDoor();
}

public void pressClose() {
    car.closeDoor();
}

public void pressAlarm() {
    car.triggerEmergency();
}
}
