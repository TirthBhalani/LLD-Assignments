import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;

public class SlidingWindowRateLimiter implements RateLimiter {
    private final RateLimitRule rule;
    private final ConcurrentMap<String, Queue<Long>> requestTimestamps;

    public SlidingWindowRateLimiter(RateLimitRule rule) {
        this.rule = rule;
        this.requestTimestamps = new ConcurrentHashMap<>();
    }

    @Override
    public boolean isAllowed(String key) {
        long now = System.currentTimeMillis();
        long windowStart = now - rule.getWindowDurationInMillis();

        Queue<Long> timestamps = requestTimestamps.computeIfAbsent(key, k -> new ConcurrentLinkedQueue<>());

        synchronized (timestamps) {
            while (!timestamps.isEmpty() && timestamps.peek() <= windowStart) {
                timestamps.poll();
            }

            if (timestamps.size() < rule.getMaxRequests()) {
                timestamps.add(now);
                return true;
            }
            return false;
        }
    }
}
