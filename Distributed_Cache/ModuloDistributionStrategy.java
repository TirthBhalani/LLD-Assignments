import java.util.List;

public class ModuloDistributionStrategy<K, V> implements DistributionStrategy<K, V> {
    @Override
    public CacheNode<K, V> getAssignedNode(K key, List<CacheNode<K, V>> nodes) {
        int hash = Math.abs(key.hashCode());
        return nodes.get(hash % nodes.size());
    }
}
