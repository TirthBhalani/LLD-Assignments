public interface DataSource<K, V> {
    V read(K key);
    void write(K key, V value);
}
