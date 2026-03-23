import java.util.List;

public interface SlotAssignmentStrategy {
    ParkingSlot assignSlot(Vehicle vehicle, Gate entryGate, List<ParkingSlot> slots);
}
