import java.util.Map;

public class HourlyPricingStrategy implements PricingStrategy {
    private Map<SlotType, Double> hourlyRates;

    public HourlyPricingStrategy(Map<SlotType, Double> hourlyRates) {
        this.hourlyRates = hourlyRates;
    }

    @Override
    public double calculatePrice(Ticket ticket, long exitTime) {
        long durationMillis = exitTime - ticket.getEntryTime();
        double hours = Math.ceil(durationMillis / (1000.0 * 60 * 60)); 
        
        if (hours == 0) hours = 1;

        // Requirement: Bill based on allocated slot type, not vehicle type
        double rate = hourlyRates.get(ticket.getSlot().getType());
        return hours * rate;
    }
}
