package com.company.mycollections;

import java.util.Iterator;

public class MyArrayListIterator<T> implements Iterator<T> {
    private final T[] array;
    private final int count;
    private int current = 0;

    public MyArrayListIterator(T[] array, int count) {
        this.array = array;
        this.count = count;
    }

    @Override
    public boolean hasNext() {
        return current < count;
    }

    @Override
    public T next() {
        return array[current++];
    }
}
