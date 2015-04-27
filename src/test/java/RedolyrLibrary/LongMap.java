package RedolyrLibrary;

import java.util.Arrays;

/**
 * Created by redolyr on 2014/12/10.
 */
public class LongMap<K, V> {

    private Entry<K, V>[][] entries;
    private int length;
    private int length1;

    public static final int MAX_VALUE = 268435455;//0xFFFFFFF

    public static class Entry<K, V> {
        private final K key;
        private final V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Entry)) return false;

            Entry entry = (Entry) o;

            if (key != null ? !key.equals(entry.key) : entry.key != null) return false;
            if (value != null ? !value.equals(entry.value) : entry.value != null) return false;

            return true;
        }

        public int hashCode() {
            int result = key != null ? key.hashCode() : 0;
            result = 31 * result + (value != null ? value.hashCode() : 0);
            return result;
        }

        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    public void add(Entry<K, V> entry) {
        if (this.entries == null) this.entries = new Entry[1][1];
        else this.entries = Arrays.copyOf(this.entries, this.length + 1);

        this.hasAndReplace(entry, this.length, this.length1);

        ++this.length1;

        if (this.length1 == this.MAX_VALUE) ++this.length;
    }

    public void hasAndReplace(Entry<K, V> entry, int length, int length1) {
        int index = -1;
        int index1 = -1;
        for (int len = 0; len < this.length; ++len) {
            for (int len1 = 0; len1 < this.length1; ++len1) {
                Entry<K, V> kvEntry = this.entries[len][len1];
                System.out.println(kvEntry);
                if (entry.equals(kvEntry)) {
                    index = len;
                    index1 = len1;
                    break;
                }
            }
        }

        boolean isIndexError = index == -1;
        boolean isIndex1Error = index1 == -1;
        if (!isIndexError && !isIndex1Error) this.entries[index][index1] = entry;
        else this.entries[length][length1] = entry;
    }

    public void add(K key, V value) {
        this.add(new Entry<K, V>(key, value));
    }

    public Object[] contains(Entry<K, V> entry, int mode) {
        boolean contains = false;
        int index = -1;
        int index1 = -1;
        for (int len = 0; len < this.length; ++len) {
            for (int len1 = 0; len1 < this.length1; ++len1) {
                Entry<K, V> kvEntry = this.entries[len][len1];
                if (mode == 0 ? entry.getKey().equals(kvEntry.getKey()) : mode == 1 ? entry.getValue().equals(kvEntry.getValue()) : mode == 3 ? kvEntry.equals(entry) : false) {
                    contains = true;
                    break;
                }
            }
        }
        return new Object[]{contains, index, index1};
    }

    public boolean containsKey(K key) {
        return Boolean.valueOf(String.valueOf(this.contains(new Entry<K, V>(key, null), 0)[0]));
    }

    public boolean containsValue(V value) {
        return Boolean.valueOf(String.valueOf(this.contains(new Entry<K, V>(null, value), 1)));
    }

    public int[] keyIndex(K key) {
        return new int[]{Integer.parseInt(String.valueOf(this.contains(new Entry<K, V>(key, null), 0)[1])), Integer.parseInt(String.valueOf(this.contains(new Entry<K, V>(key, null), 0)[2]))};
    }

    public int[] valueIndex(V value) {
        return new int[]{Integer.parseInt(String.valueOf(this.contains(new Entry<K, V>(null, value), 1)[1])), Integer.parseInt(String.valueOf(this.contains(new Entry<K, V>(null, value), 1)[2]))};
    }

    public int[] entryIndex(Entry<K, V> entry) {
        return new int[]{Integer.parseInt(String.valueOf(this.contains(entry, 3)[1])), Integer.parseInt(String.valueOf(this.contains(entry, 3)[2]))};
    }

    public void remove(int length, int length1, int index) {
        int numMoved = length1 - index - 1;
        if (numMoved > 0) System.arraycopy(this.entries[length], index + 1, this.entries[length], index, numMoved);
        this.entries[length][--length1] = null;
    }

    public void removeKey(K key) {
        this.remove(this.keyIndex(key)[0], this.length, this.keyIndex(key)[1]);
    }

    public void removeValue(V value) {
        this.remove(this.valueIndex(value)[0], this.length, this.valueIndex(value)[1]);
    }

    public void remove(Entry<K, V> entry) {
        this.remove(this.entryIndex(entry)[0], this.length, this.entryIndex(entry)[1]);
    }

    public Entry<K, V>[][] getEntries() {
        return this.entries;
    }

    public String paramString() {
        String buffer = "{";
        for (int len = 0; len < this.length; ++len) buffer += this.entries[len] + (len == this.length - 1 ? "" : ", ");
        buffer += "}";
        return buffer;
    }

    public boolean equalses(LongMap longMap) {
        if (this.entries.equals(longMap.entries)) return true;

        return true;
    }

    public int hashCode(int result) {
        for (int len = 0; len < this.length; ++len) result += 31 * result + Arrays.hashCode(this.entries[len]);
        return result;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LongMap)) return false;

        LongMap longMap = (LongMap) o;

        if (this.length != longMap.length) return false;
        if (this.length1 != longMap.length1) return false;

        return this.equalses(longMap);
    }

    public int hashCode() {
        int result = length;
        result = 31 * result + length1;
        return this.hashCode(result);
    }

    public String toString() {
        return "LongMap" + this.paramString();
    }
}
