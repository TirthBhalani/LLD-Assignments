import java.util.List;

public class ShortestPathStrategy implements ElevatorSelectionStrategy {
public ElevatorCar selectElevator(List<ElevatorCar> elevators, int floor, Direction direction) {
ElevatorCar bestCar = null;
int minDistance = Integer.MAX_VALUE;

    for (int i = 0; i < elevators.size(); i++) {
        ElevatorCar car = elevators.get(i);
        if (car.getState() == ElevatorState.MAINTENANCE) {
            continue;
        }
        int distance = Math.abs(car.getCurrentFloor() - floor);
        if (distance < minDistance) {
            minDistance = distance;
            bestCar = car;
        }
    }
    return bestCar;
}
}
