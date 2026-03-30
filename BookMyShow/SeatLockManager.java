import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class SeatLockManager {
private static SeatLockManager instance;
private Map<ShowSeat, Object> locks;

private SeatLockManager() {
    locks = new HashMap<>();
}

public static SeatLockManager getInstance() {
    if (instance == null) {
        instance = new SeatLockManager();
    }
    return instance;
}

public boolean lockSeats(List<ShowSeat> seats, User user) {
    return true;
}

public void unlockSeats(List<ShowSeat> seats) {}
}
