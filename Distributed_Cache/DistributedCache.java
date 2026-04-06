import java.util.List;

public class DistributedCache<K, V> {
    private final DistributionStrategy<K, V> distributionStrategy;
    private final List<CacheNode<K, V>> cacheNodes;
    private final DataSource<K, V> dataSource;

    public DistributedCache(DistributionStrategy<K, V> distributionStrategy, List<CacheNode<K, V>> cacheNodes, DataSource<K, V> dataSource) {
        this.distributionStrategy = distributionStrategy;
        this.cacheNodes = cacheNodes;
        this.dataSource = dataSource;
    }

    public V get(K key) {
        CacheNode<K, V> node = distributionStrategy.getAssignedNode(key, cacheNodes);
        V value = node.get(key);
        
        if (value == null) {
            value = dataSource.read(key);
            if (value != null) {
                node.put(key, value);
            }
        }
        return value;
    }

    public void put(K key, V value) {
        CacheNode<K, V> node = distributionStrategy.getAssignedNode(key, cacheNodes);
        node.put(key, value);
        dataSource.write(key, value);
    }
}
