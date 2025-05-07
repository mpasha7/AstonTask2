package com.company.mycollections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;

public class MyArrayList<T> implements Iterable<T> {
    private static final int DEFAULT_CAPACITY = 8;

    private T[] array;
    private int count = 0;
    private int capacity;
    private boolean resizeMode = false;

    public MyArrayList() {
        capacity = DEFAULT_CAPACITY;
        array = (T[]) new Object[capacity];
    }

    public MyArrayList(int size) {
        capacity = size;
        array = (T[]) new Object[capacity];
    }

    public MyArrayList(T[] other) {
        capacity = other.length * 2;
        array = (T[]) new Object[capacity];
        for (int i = 0; i < other.length; i++) {
            this.add(other[i]);
        }
    }

    public void add(T item) {
        array[count++] = item;
        if (!resizeMode)
            tryResize();
    }

    public void insert(int index, T item) {
        if (index < 0 || index >= count) {
            System.out.println("Index out of range");
            return;
        }
        for (int i = count - 1; i >= index ; i--) {
            array[i + 1] = array[i];
        }
        array[index] = item;
        count++;
        if (!resizeMode)
            tryResize();
    }

    public void addAll(Collection<T> collection) {
        for (T item : collection) {
            this.add(item);
        }
    }

    public void addAll(MyArrayList<T> collection) {
        for (T item : collection) {
            this.add(item);
        }
    }

    public int indexOf(T item) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (array[i].equals(item))
                return i;
        }
        return index;
    }

    public int lastIndexOf(T item) {
        int index = -1;
        for (int i = count - 1; i >= 0; i--) {
            if (array[i].equals(item))
                index = i;
        }
        return index;
    }

    public T removeAt(int index) {
        if (index < 0 || index >= count) {
            System.out.println("Index out of range");
            return null;
        }
        T result = array[index];
        for (int i = index; i < count - 1; i++) {
            array[i] = array[i + 1];
        }
        count--;
        if (!resizeMode)
            tryResize();
        return result;
    }

    public boolean remove(T item) {
        int index;
        return (index = indexOf(item)) != -1 && removeAt(index) != null;
    }

    public boolean removeLast(T item) {
        int index;
        return (index = lastIndexOf(item)) != -1 && removeAt(index) != null;
    }

    public int removeAll(Collection<T> collection) {
        return removeIf(collection::contains);
    }

    public int removeAll(MyArrayList<T> collection) {
        return removeIf(collection::contains);
    }

    public boolean contains(T item) {
        return indexOf(item) >= 0;
    }

    public int removeIf(Predicate<? super T> filter) {
        MyArrayList<Integer> removedList = new MyArrayList<Integer>();
        for (int i = 0; i < count; i++) {
            if (filter.test(array[i]))
                removedList.add(i);
        }
        for (int i = removedList.size() - 1; i >= 0; i--) {
            removeAt(removedList.get(i));
        }
        return removedList.size();
    }

    public T get(int index) {
        return array[index];
    }

    private void tryResize() {
        if (count >= capacity) {
            resizeMode = true;
            resize(true);
            resizeMode = false;
        }
        else if (count < capacity / 2 && capacity > DEFAULT_CAPACITY) {
            resizeMode = true;
            resize(false);
            resizeMode = false;
        }
    }

    private void resize(boolean toUp) {
        T[] oldArray = array;
        capacity = toUp ? capacity * 2 : capacity / 2;
        array = (T[]) new Object[capacity];
        int oldCount = count;
        count = 0;
        for (int i = 0; i < oldCount; i++) {
            this.add(oldArray[i]);
        }
    }

    public int size() {
        return count;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator<T>(array, count);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (T item : this) {
            result.append(item + ", ");
        }
        result.delete(result.length() - 2, result.length());
        result.append("]");
        return result.toString();
    }
}
