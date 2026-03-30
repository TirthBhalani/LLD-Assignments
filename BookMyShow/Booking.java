import java.util.List;

public class Booking {
private String id;
private String bookingDate;
private BookingStatus status;
private double totalAmount;
private Customer customer;
private Show show;
private List<ShowSeat> seats;
private PaymentProcessor paymentProcessor;

public void cancelBooking() {
    this.status = BookingStatus.CANCELLED;
}
}
