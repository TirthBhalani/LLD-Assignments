public interface PricingStrategy {
double calculatePrice(Show show, Seat seat, double basePrice, double bookedPercentage);
}
