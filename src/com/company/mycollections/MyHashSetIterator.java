package com.company.mycollections;

import java.util.Iterator;

public class MyHashSetIterator<T> implements Iterator<T> {
    private final MyNode<T>[] table;
    private MyNode<T> currentNode = null;
    private MyNode<T> nextNode = null;

    public MyHashSetIterator(MyNode<T>[] table){
        this.table = table;
    }

    @Override
    public boolean hasNext() {
        int i = currentNode == null ? 0 : currentNode.getBucket();
        for (; i < table.length; i++) {
            if (table[i] == null)
                continue;
            if (currentNode != null && currentNode.getBucket() == i) {
                if (currentNode.getNext() != null) {
                    nextNode = currentNode.getNext();
                    return true;
                }
            }
            else {
                if (table[i] != null){
                    nextNode = table[i];
                    return true;
                }
            }
        }
        nextNode = null;
        return false;
    }

    @Override
    public T next() {
        if (nextNode != null || hasNext()) {
            currentNode = nextNode;
            nextNode = null;
            return currentNode.getItem();
        }
//        throw new NoSuchElementException("Next element is null");
        // ??????????????????
        try {
            throw new NoSuchFieldException();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }
}
