package RedolyrLibrary.table;

/**
 * Created by redolyr on 2014/11/07.
 */
public interface TestMapTable<K, V> {
    public void add(K key, V value);

    public V get(K key);

    public void remove(K key);
}
