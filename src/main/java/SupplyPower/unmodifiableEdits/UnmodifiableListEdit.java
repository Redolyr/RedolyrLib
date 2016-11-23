package SupplyPower.unmodifiableEdits;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by hyres on 2016/11/23.
 */
public class UnmodifiableListEdit<T> implements List<T> {

    private static Class unmodifiableListClass;
    private static Field listField;
    protected final List<T> list;

    public UnmodifiableListEdit(Object object) throws IllegalAccessException {
        this.list = (List<T>) listField.get(object);
    }

    public int size() {
        return this.list.size();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public boolean contains(Object o) {
        return this.list.contains(o);
    }

    public Iterator<T> iterator() {
        return this.list.iterator();
    }

    public Object[] toArray() {
        return this.list.toArray();
    }

    public <T1> T1[] toArray(T1[] a) {
        return this.list.toArray(a);
    }

    public boolean add(T t) {
        return this.list.add(t);
    }

    public boolean remove(Object o) {
        return this.list.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return this.list.containsAll(c);
    }

    public boolean addAll(Collection<? extends T> c) {
        return this.list.addAll(c);
    }

    public boolean addAll(int index, Collection<? extends T> c) {
        return this.list.addAll(index, c);
    }

    public boolean removeAll(Collection<?> c) {
        return this.list.removeAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return this.list.retainAll(c);
    }

    public void clear() {
        this.list.clear();
    }

    public boolean equals(Object o) {
        return this.list.equals(o);
    }

    public int hashCode() {
        return this.list.hashCode();
    }

    public T get(int index) {
        return this.list.get(index);
    }

    public T set(int index, T element) {
        return this.list.set(index, element);
    }

    public void add(int index, T element) {
        this.list.add(index, element);
    }

    public T remove(int index) {
        return this.list.remove(index);
    }

    public int indexOf(Object o) {
        return this.list.indexOf(o);
    }

    public int lastIndexOf(Object o) {
        return this.list.lastIndexOf(o);
    }

    public ListIterator<T> listIterator() {
        return this.list.listIterator();
    }

    public ListIterator<T> listIterator(final int index) {
        return this.list.listIterator(index);
    }

    public List<T> subList(int fromIndex, int toIndex) {
        try {
            return new UnmodifiableListEdit<T>(this.list.subList(fromIndex, toIndex));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Object readResolve() throws IllegalAccessException {
        return (this.list instanceof RandomAccess ? new UnmodifiableRandomAccessListEdit<T>(this.list) : this);
    }

    public String toString() {
        return this.list.toString();
    }

    static {
        try {
            unmodifiableListClass = Class.forName("java.util.Collections$UnmodifiableList");
            listField = unmodifiableListClass.getDeclaredField("list");

            listField.setAccessible(true);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
