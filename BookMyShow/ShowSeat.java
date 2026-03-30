public class ShowSeat {
private String id;
private double currentPrice;
private SeatStatus status;
private Seat seat;

public void lockSeat() {
    this.status = SeatStatus.LOCKED;
}

public void bookSeat() {
    this.status = SeatStatus.BOOKED;
}

public void freeSeat() {
    this.status = SeatStatus.AVAILABLE;
}
}
