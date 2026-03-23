import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ParkingLotSystem {
    private List<ParkingSlot> slots;
    private Map<String, Gate> gates;
    private Map<String, Ticket> activeTickets;
    private SlotAssignmentStrategy assignmentStrategy;
    private PricingStrategy pricingStrategy;

    public ParkingLotSystem(List<ParkingSlot> slots, List<Gate> gates, 
                            SlotAssignmentStrategy assignmentStrategy, 
                            PricingStrategy pricingStrategy) {
        this.slots = slots;
        this.assignmentStrategy = assignmentStrategy;
        this.pricingStrategy = pricingStrategy;
        this.activeTickets = new HashMap<>();
        this.gates = new HashMap<>();
        
        for (Gate gate : gates) {
            this.gates.put(gate.getGateId(), gate);
        }
    }

    public Ticket park(Vehicle vehicle, long entryTime, String entryGateId) {
        Gate gate = gates.get(entryGateId);
        if (gate == null) {
            throw new IllegalArgumentException("Invalid gate ID.");
        }

        ParkingSlot slot = assignmentStrategy.assignSlot(vehicle, gate, slots);
        if (slot == null) {
            System.out.println("No compatible slots available for " + vehicle.getLicensePlate());
            return null;
        }

        slot.parkVehicle();
        String ticketId = UUID.randomUUID().toString().substring(0, 8);
        Ticket ticket = new Ticket(ticketId, vehicle, slot, entryTime);
        activeTickets.put(ticketId, ticket);

        System.out.println("Vehicle " + vehicle.getLicensePlate() + " parked at slot " + 
                           slot.getSlotId() + " (" + slot.getType() + "). Ticket ID: " + ticketId);
        return ticket;
    }

    public Map<SlotType, Integer> status() {
        Map<SlotType, Integer> availability = new HashMap<>();
        availability.put(SlotType.SMALL, 0);
        availability.put(SlotType.MEDIUM, 0);
        availability.put(SlotType.LARGE, 0);

        for (ParkingSlot slot : slots) {
            if (!slot.isOccupied()) {
                availability.put(slot.getType(), availability.get(slot.getType()) + 1);
            }
        }
        return availability;
    }

    public double exit(String ticketId, long exitTime) {
        Ticket ticket = activeTickets.get(ticketId);
        if (ticket == null) {
            throw new IllegalArgumentException("Invalid ticket ID.");
        }

        double amount = pricingStrategy.calculatePrice(ticket, exitTime);
        ticket.getSlot().removeVehicle();
        activeTickets.remove(ticketId);

        System.out.println("Vehicle " + ticket.getVehicle().getLicensePlate() + " exiting. " +
                           "Slot " + ticket.getSlot().getSlotId() + " freed. Total Bill: $" + amount);
        return amount;
    }
}
