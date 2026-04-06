import java.util.List;

public interface DistributionStrategy<K, V> {
    CacheNode<K, V> getAssignedNode(K key, List<CacheNode<K, V>> nodes);
}
