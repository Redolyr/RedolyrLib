package RedolyrLibrary.dataSystems;

/**
 * Created by redolyr on 2014/11/06.
 */
public class DataListEntry<K extends DataBase> {
    private K key;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DataListEntry)) return false;

        DataListEntry that = (DataListEntry) o;

        if (key != null ? !key.equals(that.key) : that.key != null) return false;

        return true;
    }

    public int hashCode() {
        return key != null ? key.hashCode() : 0;
    }

    public String toString() {
        return "DataListEntry{" +
                "key=" + key +
                '}';
    }
}
