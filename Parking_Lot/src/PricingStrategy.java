public interface PricingStrategy {
    double calculatePrice(Ticket ticket, long exitTime);
}
