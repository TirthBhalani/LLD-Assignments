public class PaymentProcessor {
private PaymentStrategy strategy;

public boolean process(PaymentStrategy strategy, double amount) {
    this.strategy = strategy;
    return strategy.processPayment(amount);
}
}
