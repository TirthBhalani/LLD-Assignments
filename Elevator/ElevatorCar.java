public class ElevatorCar {
private int id;
private int currentFloor;
private ElevatorState state;
private double currentWeight;
private final double MAX_WEIGHT = 700.0;
private InternalPanel internalPanel;

public ElevatorCar(int id) {
    this.id = id;
    this.currentFloor = 0;
    this.state = ElevatorState.IDLE;
    this.currentWeight = 0.0;
    this.internalPanel = new InternalPanel(id, this);
}

public int getCurrentFloor() {
    return currentFloor;
}

public ElevatorState getState() {
    return state;
}

public void move(int destinationFloor) {
    if (state == ElevatorState.MAINTENANCE) {
        return;
    }
    if (currentWeight > MAX_WEIGHT) {
        triggerEmergency();
        return;
    }
    if (destinationFloor > currentFloor) {
        state = ElevatorState.MOVING_UP;
    } else if (destinationFloor < currentFloor) {
        state = ElevatorState.MOVING_DOWN;
    }
    currentFloor = destinationFloor;
    stop();
}

public void stop() {
    state = ElevatorState.IDLE;
    openDoor();
}

public void openDoor() {
}

public void closeDoor() {
}

public void triggerEmergency() {
    stop();
}

public void setMaintenance(boolean status) {
    if (status) {
        state = ElevatorState.MAINTENANCE;
    } else {
        state = ElevatorState.IDLE;
    }
}
}
