package SupplyPower.unmodifiableEdits;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by hyres on 2016/11/23.
 */
public class UnmodifiableMapEdit<K, V> implements Map<K, V> {

    private static Class unmodifiableMapClass;
    private static Field mapField;
    private final Map<K, V> map;

    public UnmodifiableMapEdit(Object object) throws IllegalAccessException {
        this.map = (Map<K, V>) mapField.get(object);
    }

    public int size() {
        return this.map.size();
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public boolean containsKey(Object key) {
        return this.map.containsKey(key);
    }

    public boolean containsValue(Object value) {
        return this.map.containsValue(value);
    }

    public V get(Object key) {
        return this.map.get(key);
    }

    public V put(K key, V value) {
        return this.map.put(key, value);
    }

    public V remove(Object key) {
        return this.map.remove(key);
    }

    public void putAll(Map<? extends K, ? extends V> m) {
        this.map.putAll(m);
    }

    public void clear() {
        this.map.clear();
    }

    public Set<K> keySet() {
        return this.map.keySet();
    }

    public Collection<V> values() {
        return this.map.values();
    }

    public Set<Entry<K, V>> entrySet() {
        return this.map.entrySet();
    }

    public String toString() {
        return this.map.toString();
    }
    
    static {
        try {
            unmodifiableMapClass = Class.forName("java.util.Collections$UnmodifiableMap");
            mapField = unmodifiableMapClass.getDeclaredField("m");
            
            mapField.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
