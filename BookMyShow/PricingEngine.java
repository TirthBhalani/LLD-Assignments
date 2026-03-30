import java.util.List;

public class PricingEngine {
private List<PricingStrategy> activeRules;

public void setStrategies(List<PricingStrategy> rules) {
    this.activeRules = rules;
}

public double calculateFinalPrice(Show show, Seat seat) {
    return 0.0;
}
}
