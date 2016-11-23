package SupplyPower.unmodifiableEdits;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by hyres on 2016/11/23.
 */
public class UnmodifiableSetEdit<T> implements Set<T> {

    private static Class unmodifiableSetClass;
    private static Field setField;
    private final Set<T> set;

    public UnmodifiableSetEdit(Object object) throws IllegalAccessException {
        this.set = (Set<T>) setField.get(object);
    }

    public int size() {
        return this.set.size();
    }

    public boolean isEmpty() {
        return this.set.isEmpty();
    }

    public boolean contains(Object o) {
        return this.set.contains(o);
    }

    public Iterator<T> iterator() {
        return this.set.iterator();
    }

    public Object[] toArray() {
        return this.set.toArray();
    }

    public <T1> T1[] toArray(T1[] a) {
        return this.set.toArray(a);
    }

    public boolean add(T t) {
        return this.set.add(t);
    }

    public boolean remove(Object o) {
        return this.set.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return this.set.containsAll(c);
    }

    public boolean addAll(Collection<? extends T> c) {
        return this.set.addAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return this.set.retainAll(c);
    }

    public boolean removeAll(Collection<?> c) {
        return this.set.removeAll(c);
    }

    public void clear() {
        this.set.clear();
    }

    public boolean equals(Object o) {
        return this.set.equals(o);
    }

    public int hashCode() {
        return this.set.hashCode();
    }

    public String toString() {
        return this.set.toString();
    }

    static {
        try {
            unmodifiableSetClass = Class.forName("java.util.Collections$UnmodifiableCollection");
            setField = unmodifiableSetClass.getDeclaredField("c");

            setField.setAccessible(true);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
