public class InternalService {
    private RateLimiter rateLimiter;

    public InternalService(RateLimiter rateLimiter) {
        this.rateLimiter = rateLimiter;
    }

    public void setRateLimiter(RateLimiter rateLimiter) {
        this.rateLimiter = rateLimiter;
    }

    public void processRequestAndCallExternal(String key) {
        if (rateLimiter.isAllowed(key)) {
            System.out.println("Allowed: " + key);
        } else {
            System.out.println("Denied: " + key);
        }
    }
}
