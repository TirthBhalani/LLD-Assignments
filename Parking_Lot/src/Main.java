import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Setup initial configurations
        Gate gate1 = new Gate("G1", 0, 0);
        Gate gate2 = new Gate("G2", 100, 100);

        ParkingSlot s1 = new ParkingSlot("S1", SlotType.SMALL, 10, 10);
        ParkingSlot s2 = new ParkingSlot("S2", SlotType.MEDIUM, 20, 20);
        ParkingSlot s3 = new ParkingSlot("S3", SlotType.LARGE, 30, 30);
        ParkingSlot s4 = new ParkingSlot("S4", SlotType.LARGE, 5, 5); // Very close to G1

        Map<SlotType, Double> rates = new HashMap<>();
        rates.put(SlotType.SMALL, 10.0);
        rates.put(SlotType.MEDIUM, 20.0);
        rates.put(SlotType.LARGE, 50.0);

        ParkingLotSystem system = new ParkingLotSystem(
            Arrays.asList(s1, s2, s3, s4),
            Arrays.asList(gate1, gate2),
            new NearestCompatibleSlotStrategy(),
            new HourlyPricingStrategy(rates)
        );

        System.out.println("Initial Status: " + system.status());

        Vehicle bike1 = new Vehicle("BIKE-111", VehicleType.TWO_WHEELER);
        long timeNow = System.currentTimeMillis();
        Ticket t1 = system.park(bike1, timeNow, "G1");

        Vehicle car1 = new Vehicle("CAR-222", VehicleType.CAR);
        Ticket t2 = system.park(car1, timeNow, "G1");

        Vehicle bike2 = new Vehicle("BIKE-333", VehicleType.TWO_WHEELER);
        Ticket t3 = system.park(bike2, timeNow, "G2");

        System.out.println("Status after parking: " + system.status());

        
        long twoAndHalfHoursLater = timeNow + (long)(2.5 * 60 * 60 * 1000);
        System.out.println("\n--- Processing Exits ---");
        
        if (t1 != null) system.exit(t1.getTicketId(), twoAndHalfHoursLater);
        if (t2 != null) system.exit(t2.getTicketId(), twoAndHalfHoursLater);
        if (t3 != null) system.exit(t3.getTicketId(), twoAndHalfHoursLater);
        
        System.out.println("Final Status: " + system.status());
    }
}
