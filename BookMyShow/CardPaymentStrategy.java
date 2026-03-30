public class CardPaymentStrategy implements PaymentStrategy {
private String cardNumber;

public boolean processPayment(double amount) {
    return true;
}

public boolean processRefund(double amount) {
    return true;
}
}
