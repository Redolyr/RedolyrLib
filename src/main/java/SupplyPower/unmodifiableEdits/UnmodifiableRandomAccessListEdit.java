package SupplyPower.unmodifiableEdits;

import java.util.List;
import java.util.RandomAccess;

/**
 * Created by hyres on 2016/11/23.
 */
public class UnmodifiableRandomAccessListEdit<T> extends UnmodifiableListEdit<T> implements RandomAccess {

    public UnmodifiableRandomAccessListEdit(List<? extends T> list) throws IllegalAccessException {
        super(list);
    }

    public List<T> subList(int fromIndex, int toIndex) {
        try {
            return new UnmodifiableRandomAccessListEdit<T>(this.list.subList(fromIndex, toIndex));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return super.subList(fromIndex, toIndex);
    }

    private Object writeReplace() throws IllegalAccessException {
        return new UnmodifiableCollectionEdit<T>(this.list);
    }
}
