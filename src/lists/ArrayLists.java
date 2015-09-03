package lists;

import lists.IList;

import java.util.*;

public class ArrayLists implements IList {
    // BEGIN
    int size = 0;
    private final static int MIN_VALUE = 10;

    private Object[] myArr;
    // END


    public synchronized void add(final Object element) {
        // BEGIN
        if (size == 0) myArr = new Object[MIN_VALUE];
        if (size == myArr.length) {
            myArr = Arrays.copyOf(myArr, myArr.length * 2);
        }

        myArr[size] = element;
        size++;

        // END

    }

    public synchronized void removeLast() {
        // BEGIN

        myArr[size - 1] = null;
        size--;

        // END

    }

    public int size() {
        // BEGIN
        return size;

        // END

    }

    public Object get(final int index) {
        // BEGIN
        if (index <= size) return myArr[index];
        return null;
        // END

    }

    public synchronized void set(final int index, final Object object) {
        // BEGIN
        if (index <= size) myArr[index] = object;

        // END

    }
}