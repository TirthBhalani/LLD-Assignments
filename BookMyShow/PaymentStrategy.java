public interface PaymentStrategy {
boolean processPayment(double amount);
boolean processRefund(double amount);
}
