package SupplyPower.unmodifiableEdits;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by redolyr on 2016/08/30.
 */
public class UnmodifiableCollectionEdit<T> implements Collection<T> {

    private static Class unmodifiableCollectionClass;
    private static Class arrayListClass;
    private static Field collection1sField;
    private static Field arrayField;
    private final Collection<T> collection0;
    private final Collection<T> collection1;
    private final ArrayList<T> arrayList;
    private final Iterator<T> iterator;

    public UnmodifiableCollectionEdit(Object object) throws IllegalAccessException {
        this.collection0 = (Collection<T>) object;
        this.collection1 = (Collection<T>) this.collection1sField.get(object);
        this.arrayList = new ArrayList<T>(Arrays.asList((T[]) this.arrayField.get(this.collection1)));
        this.iterator = this.arrayList.iterator();
    }

    private static <T> void update(UnmodifiableCollectionEdit<T> edit) throws IllegalAccessException {
        UnmodifiableCollectionEdit.arrayField.set(edit.collection1, edit.arrayList.toArray(new Object[0]));
        UnmodifiableCollectionEdit.collection1sField.set(edit.collection0, edit.collection1);
    }

    public int size() {
        return this.arrayList.size();
    }

    public boolean isEmpty() {
        return this.arrayList.isEmpty();
    }

    public boolean contains(Object o) {
        return this.arrayList.contains(o);
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            public boolean hasNext() {
                return UnmodifiableCollectionEdit.this.iterator.hasNext();
            }

            public T next() {
                return UnmodifiableCollectionEdit.this.iterator.next();
            }

            public void remove() {
                try {
                    UnmodifiableCollectionEdit.this.iterator.remove();
                    UnmodifiableCollectionEdit.update(UnmodifiableCollectionEdit.this);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public Object[] toArray() {
        return this.arrayList.toArray();
    }

    public <T1> T1[] toArray(T1[] a) {
        return this.arrayList.toArray(a);
    }

    public boolean add(T t) {
        boolean ret = this.arrayList.add(t);
        try {
            UnmodifiableCollectionEdit.update(this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public boolean remove(Object o) {
        boolean ret = this.arrayList.remove(o);
        try {
            UnmodifiableCollectionEdit.update(this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public boolean containsAll(Collection<?> c) {
        return this.arrayList.containsAll(c);
    }

    public boolean addAll(Collection<? extends T> c) {
        boolean ret = this.arrayList.addAll(c);
        try {
            UnmodifiableCollectionEdit.update(this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public boolean removeAll(Collection<?> c) {
        boolean ret = this.arrayList.removeAll(c);
        try {
            UnmodifiableCollectionEdit.update(this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public boolean retainAll(Collection<?> c) {
        boolean ret = this.arrayList.retainAll(c);
        try {
            UnmodifiableCollectionEdit.update(this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public void clear() {
        this.arrayList.clear();
        try {
            UnmodifiableCollectionEdit.update(this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        return this.arrayList.toString();
    }

    static {
        try {
            unmodifiableCollectionClass = Class.forName("java.util.Collections$UnmodifiableCollection");
            arrayListClass = Class.forName("java.util.Arrays$ArrayList");
            collection1sField = unmodifiableCollectionClass.getDeclaredField("c");
            arrayField = arrayListClass.getDeclaredField("a");
            collection1sField.setAccessible(true);
            arrayField.setAccessible(true);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
