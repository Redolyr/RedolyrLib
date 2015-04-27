package RedolyrLibrary;

import java.util.Arrays;
import java.util.Iterator;

public class Itr<E> implements Iterator<E> {
    private E[] es;
    private int length;
    private int index;

    public Itr(E[] es) {
        this.es = es;
        this.length = es.length;
    }

    public boolean hasNext() {
        return this.index < this.length && this.es[this.index] != null;
    }

    public E next() {
        return this.es[this.index++];
    }

    public void remove() {
        this.remove(this.length - this.index - 1);
    }

    public void remove(int index) {
        int removeIndex = Arrays.binarySearch(this.es, this.es[this.index]);
        int len = removeIndex - index;
        System.out.println(len);
        if (len > 0) System.arraycopy(this.es, len + 1, this.es, len, index);
        this.es[len] = null;
    }
}
