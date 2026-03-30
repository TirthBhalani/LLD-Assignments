import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {
private static ElevatorSystem instance;
private List<ElevatorCar> elevators;
private List<ExternalPanel> externalPanels;
private ElevatorSelectionStrategy strategy;

private ElevatorSystem() {
    elevators = new ArrayList<>();
    externalPanels = new ArrayList<>();
}

public static ElevatorSystem getInstance() {
    if (instance == null) {
        instance = new ElevatorSystem();
    }
    return instance;
}

public void setStrategy(ElevatorSelectionStrategy strategy) {
    this.strategy = strategy;
}

public void addElevator(ElevatorCar car) {
    elevators.add(car);
}

public void addExternalPanel(ExternalPanel panel) {
    externalPanels.add(panel);
}

public void requestElevator(int floor, Direction direction) {
    if (strategy == null || elevators.isEmpty()) {
        return;
    }
    ElevatorCar optimalCar = strategy.selectElevator(elevators, floor, direction);
    if (optimalCar != null) {
        optimalCar.move(floor);
    }
}
}
