public class UPIPaymentStrategy implements PaymentStrategy {
private String upiId;

public boolean processPayment(double amount) {
    return true;
}

public boolean processRefund(double amount) {
    return true;
}
}
