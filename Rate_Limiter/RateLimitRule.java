public class RateLimitRule {
    private final int maxRequests;
    private final long windowDurationInMillis;

    public RateLimitRule(int maxRequests, long windowDurationInMillis) {
        this.maxRequests = maxRequests;
        this.windowDurationInMillis = windowDurationInMillis;
    }

    public int getMaxRequests() {
        return maxRequests;
    }

    public long getWindowDurationInMillis() {
        return windowDurationInMillis;
    }
}
