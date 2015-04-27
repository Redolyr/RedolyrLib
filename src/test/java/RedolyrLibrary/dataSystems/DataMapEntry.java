package RedolyrLibrary.dataSystems;

/**
 * Created by redolyr on 2014/11/06.
 */
public class DataMapEntry<K extends DataBase, V> {
    private K key;
    private V value;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DataMapEntry)) return false;

        DataMapEntry DataMapEntry = (DataMapEntry) o;

        if (key != null ? !key.equals(DataMapEntry.key) : DataMapEntry.key != null) return false;
        if (value != null ? !value.equals(DataMapEntry.value) : DataMapEntry.value != null) return false;

        return true;
    }

    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    public String toString() {
        return "DataMapEntry{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
