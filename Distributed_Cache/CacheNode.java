import java.util.HashMap;
import java.util.Map;

public class CacheNode<K, V> {
    private final String nodeId;
    private final int capacity;
    private final Map<K, V> storage;
    private final EvictionPolicy<K> evictionPolicy;

    public CacheNode(String nodeId, int capacity, EvictionPolicy<K> evictionPolicy) {
        this.nodeId = nodeId;
        this.capacity = capacity;
        this.storage = new HashMap<>();
        this.evictionPolicy = evictionPolicy;
    }

    public V get(K key) {
        if (storage.containsKey(key)) {
            evictionPolicy.keyAccessed(key);
            return storage.get(key);
        }
        return null;
    }

    public void put(K key, V value) {
        if (!storage.containsKey(key) && storage.size() >= capacity) {
            K evictedKey = evictionPolicy.evict();
            if (evictedKey != null) {
                storage.remove(evictedKey);
            }
        }
        storage.put(key, value);
        evictionPolicy.keyAccessed(key);
    }
}
