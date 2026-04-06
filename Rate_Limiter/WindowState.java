import java.util.concurrent.atomic.AtomicInteger;

public class WindowState {
    private long windowStartTimestamp;
    private final AtomicInteger counter;

    public WindowState(long windowStartTimestamp, AtomicInteger counter) {
        this.windowStartTimestamp = windowStartTimestamp;
        this.counter = counter;
    }

    public long getWindowStartTimestamp() {
        return windowStartTimestamp;
    }

    public void setWindowStartTimestamp(long windowStartTimestamp) {
        this.windowStartTimestamp = windowStartTimestamp;
    }

    public AtomicInteger getCounter() {
        return counter;
    }
}
