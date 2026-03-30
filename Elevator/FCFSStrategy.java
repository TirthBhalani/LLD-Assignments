import java.util.List;

public class FCFSStrategy implements ElevatorSelectionStrategy {
public ElevatorCar selectElevator(List<ElevatorCar> elevators, int floor, Direction direction) {
for (int i = 0; i < elevators.size(); i++) {
ElevatorCar car = elevators.get(i);
if (car.getState() == ElevatorState.IDLE) {
return car;
}
}
return elevators.isEmpty() ? null : elevators.get(0);
}
}
