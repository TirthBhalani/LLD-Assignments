public class Main {
    public static void main(String[] args) {
        RateLimitRule rule = new RateLimitRule(5, 60000);
        
        System.out.println("Testing Fixed Window Rate Limiter");
        RateLimiter fixedLimiter = new FixedWindowRateLimiter(rule);
        InternalService service = new InternalService(fixedLimiter);
        
        for (int i = 0; i < 6; i++) {
            service.processRequestAndCallExternal("T1");
        }
        
        System.out.println("Testing Sliding Window Rate Limiter");
        RateLimiter slidingLimiter = new SlidingWindowRateLimiter(rule);
        service.setRateLimiter(slidingLimiter);
        
        for (int i = 0; i < 6; i++) {
            service.processRequestAndCallExternal("T2");
        }
    }
}
