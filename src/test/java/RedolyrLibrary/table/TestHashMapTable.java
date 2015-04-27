package RedolyrLibrary.table;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by redolyr on 2014/11/07.
 */
public class TestHashMapTable<K, V> implements TestMapTable<K, V> {
    private TestMapEntryTable<K, V>[] kvTestMapEntryTables;
    private int kvTestMapEntryTablesLength = 0;

    public TestHashMapTable() {
        this.kvTestMapEntryTables = new TestMapEntryTable[0];
    }

    public void add(K key, V value) {
        this.kvTestMapEntryTables = copyOf(this.kvTestMapEntryTables, this.kvTestMapEntryTablesLength + 1);
        TestMapEntryTable<K, V> TestMapEntryTable = new TestMapEntryTable<K, V>();
        TestMapEntryTable.setKey(key);
        TestMapEntryTable.setValue(value);
        this.kvTestMapEntryTables[this.kvTestMapEntryTablesLength] = TestMapEntryTable;
        ++this.kvTestMapEntryTablesLength;
    }

    public V get(K key) {
        V value = null;
        for (TestMapEntryTable<K, V> TestMapEntryTable : this.kvTestMapEntryTables) {
            value = TestMapEntryTable.getValue();
            if (key.equals(TestMapEntryTable.getKey())) break;
        }
        return value;
    }

    public void remove(K key) {
        int length = -1;
        for (int len = 0; len < this.kvTestMapEntryTablesLength; ++len) {
            TestMapEntryTable<K, V> testMapEntryTable = this.kvTestMapEntryTables[len];
            length = len;
            if (key.equals(testMapEntryTable.getKey())) break;
        }
        this.kvTestMapEntryTables[length] = null;
        TestMapEntryTable<K, V>[] testMapEntryTables = new TestMapEntryTable[this.kvTestMapEntryTablesLength];
        length = 0;
        for (int len = 0; len < this.kvTestMapEntryTablesLength; ++len) {
            TestMapEntryTable<K, V> testMapEntryTable = this.kvTestMapEntryTables[len];
            if (testMapEntryTable != null) testMapEntryTables[len] = testMapEntryTable;
            ++length;
        }
        this.kvTestMapEntryTables = Arrays.copyOf(testMapEntryTables, length);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestHashMapTable)) return false;

        TestHashMapTable that = (TestHashMapTable) o;

        if (this.kvTestMapEntryTablesLength != that.kvTestMapEntryTablesLength) return false;
        if (!this.equals(this.kvTestMapEntryTables, that.kvTestMapEntryTables)) return false;

        return true;
    }

    private boolean equals(Object[] a, Object[] a2) {
        if (a == a2) return true;
        if (a == null || a2 == null) return false;

        int length = a.length;
        if (a2.length != length) return false;

        for (int i = 0; i < length; i++) {
            Object o1 = a[i];
            Object o2 = a2[i];
            if (!(o1 == null ? o2 == null : o1.equals(o2))) return false;
        }

        return true;
    }

    private <T extends Object> T[] copyOf(T[] ts, int length) {
        T[] copy = ((Object) ts.getClass() == (Object) Object[].class) ? (T[]) new Object[length] : (T[]) Array.newInstance(ts.getClass().getComponentType(), length);
        System.arraycopy(ts, 0, copy, 0, Math.min(ts.length, length));
        return copy;
    }

    public int hashCode() {
        int result = 1;
        for (Object element : this.kvTestMapEntryTables)
            result = 31 * result + (element == null ? 0 : element.hashCode());
        result = 31 * result + this.kvTestMapEntryTablesLength;
        return result;
    }

    private String toString(Object[] objects) {
        if (objects == null) return "null";
        int iMax = objects.length - 1;
        if (iMax == -1) return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(objects[i]);
            if (i == iMax) return b.append(']').toString();
            b.append(", ");
        }
    }

    public String toString() {
        return "TestHashMapTable{" +
                "kvTestMapEntryTables=" + toString(kvTestMapEntryTables) +
                '}';
    }
}
