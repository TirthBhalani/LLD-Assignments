import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public class FixedWindowRateLimiter implements RateLimiter {
    private final RateLimitRule rule;
    private final ConcurrentMap<String, WindowState> windows;

    public FixedWindowRateLimiter(RateLimitRule rule) {
        this.rule = rule;
        this.windows = new ConcurrentHashMap<>();
    }

    @Override
    public boolean isAllowed(String key) {
        long now = System.currentTimeMillis();
        long currentWindowStart = (now / rule.getWindowDurationInMillis()) * rule.getWindowDurationInMillis();

        WindowState state = windows.computeIfAbsent(key, k -> new WindowState(currentWindowStart, new AtomicInteger(0)));

        synchronized (state) {
            if (state.getWindowStartTimestamp() != currentWindowStart) {
                state.setWindowStartTimestamp(currentWindowStart);
                state.getCounter().set(0);
            }
            return state.getCounter().incrementAndGet() <= rule.getMaxRequests();
        }
    }
}
