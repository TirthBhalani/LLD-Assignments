import java.util.LinkedHashSet;
import java.util.Set;

public class LRUEvictionPolicy<K> implements EvictionPolicy<K> {
    private final Set<K> keys = new LinkedHashSet<>();

    @Override
    public void keyAccessed(K key) {
        keys.remove(key);
        keys.add(key);
    }

    @Override
    public K evict() {
        if (keys.isEmpty()) {
            return null;
        }
        K first = keys.iterator().next();
        keys.remove(first);
        return first;
    }
}
