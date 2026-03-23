import java.util.Arrays;
import java.util.List;

public class NearestCompatibleSlotStrategy implements SlotAssignmentStrategy {

    @Override
    public ParkingSlot assignSlot(Vehicle vehicle, Gate entryGate, List<ParkingSlot> slots) {
        List<SlotType> allowedTypes = getCompatibleSlotTypes(vehicle.getType());
        
        ParkingSlot nearestSlot = null;
        double minDistance = Double.MAX_VALUE;

        for (ParkingSlot slot : slots) {
            if (!slot.isOccupied() && allowedTypes.contains(slot.getType())) {
                double distance = slot.getDistance(entryGate);
                if (distance < minDistance) {
                    minDistance = distance;
                    nearestSlot = slot;
                }
            }
        }
        return nearestSlot;
    }

    private List<SlotType> getCompatibleSlotTypes(VehicleType type) {
        switch (type) {
            case TWO_WHEELER:
                return Arrays.asList(SlotType.SMALL, SlotType.MEDIUM, SlotType.LARGE);
            case CAR:
                return Arrays.asList(SlotType.MEDIUM, SlotType.LARGE);
            case BUS:
                return Arrays.asList(SlotType.LARGE);
            default:
                throw new IllegalArgumentException("Unknown vehicle type");
        }
    }
}
