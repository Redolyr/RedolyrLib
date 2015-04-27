package RedolyrLibrary;

import java.util.*;

public abstract class HashIterator<E> implements Iterator<E> {
//    Entry<K,V> next;        // next entry to return
//    int expectedModCount;   // For fast-fail
//    int index;              // current slot
//    Entry<K,V> current;     // current entry
//
//    HashIterator() {
//        expectedModCount = modCount;
//        if (size > 0) { // advance to first entry
//            Map.Entry[] t = table;
//            while (index < t.length && (next = t[index++]) == null)
//                ;
//        }
//    }
//
//    public final boolean hasNext() {
//        return next != null;
//    }
//
//    final Entry<K,V> nextEntry() {
//        if (modCount != expectedModCount)
//            throw new ConcurrentModificationException();
//        Entry<K,V> e = next;
//        if (e == null)
//            throw new NoSuchElementException();
//
//        if ((next = e.next) == null) {
//            Map.Entry[] t = table;
//            while (index < t.length && (next = t[index++]) == null)
//                ;
//        }
//        current = e;
//        return e;
//    }
//
//    public void remove() {
//        if (current == null) throw new IllegalStateException();
//        if (modCount != expectedModCount) throw new ConcurrentModificationException();
//        Object k = current.key;
//        current = null;
//        this.removeEntryForKey(k);
//        expectedModCount = modCount;
//    }
//
//    final Entry<K,V> removeEntryForKey(Object key) {
//        if (size == 0) {
//            return null;
//        }
//        int hash = (key == null) ? 0 : hash(key);
//        int i = indexFor(hash, table.length);
//        Entry<K,V> prev = table[i];
//        Entry<K,V> e = prev;
//
//        while (e != null) {
//            Entry<K,V> next = e.next;
//            Object k;
//            if (e.hash == hash &&
//                    ((k = e.key) == key || (key != null && key.equals(k)))) {
//                modCount++;
//                size--;
//                if (prev == e)
//                    table[i] = next;
//                else
//                    prev.next = next;
//                e.recordRemoval(this);
//                return e;
//            }
//            prev = e;
//            e = next;
//        }
//
//        return e;
//    }
}