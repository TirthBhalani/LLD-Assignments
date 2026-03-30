import java.util.List;

public class Customer extends User {
private List<Booking> bookings;

public List<Booking> getBookings() {
    return bookings;
}
}
