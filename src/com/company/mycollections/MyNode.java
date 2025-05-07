package com.company.mycollections;

public class MyNode<T> {
    private final int hash;
    private final T item;
    private final int bucket;
    private MyNode<T> next = null;

    public MyNode(int hash, T item, int bucket){
        this.hash = hash;
        this.item = item;
        this.bucket = bucket;
    }

    public T getItem() {
        return item;
    }
    public int getHash() {
        return hash;
    }
    public int getBucket() {
        return bucket;
    }
    public MyNode<T> getNext() {
        return next;
    }
    public void setNext(MyNode<T> next) {
        this.next = next;
    }
}
