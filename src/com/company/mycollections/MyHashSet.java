package com.company.mycollections;

import java.util.Iterator;

public class MyHashSet<T> implements Iterable<T> {
    private static final int DEFAULT_CAPACITY = 8;
    private static final float DEFAULT_FILL_FACTOR = 0.75F;

    private MyNode<T>[] table;
    private int capacity;
    private float fillFactor;
    private int count = 0;
    private boolean resizeMode = false;

    public MyHashSet(){
        capacity = DEFAULT_CAPACITY;
        fillFactor = DEFAULT_FILL_FACTOR;
        table = new MyNode[this.capacity];
    }

    public MyHashSet(int capacity){
        this.capacity = capacity;
        fillFactor = DEFAULT_FILL_FACTOR;
        table = new MyNode[this.capacity];
    }

    public MyHashSet(int capacity, float fillFactor){
        this.capacity = capacity;
        this.fillFactor = fillFactor;
        table = new MyNode[this.capacity];
    }

    public MyHashSet(MyHashSet<T> other){
        this.capacity = other.capacity;
        fillFactor = DEFAULT_FILL_FACTOR;
        table = new MyNode[this.capacity];
        for (T item: other) {
            this.add(item);
        }
    }

    public void add(T item){
        int hash = getHash(item);
        int bucket = getIndex(hash);
        MyNode<T> node = new MyNode<T>(hash, item, bucket);
        if (table[bucket] == null)
            table[bucket] = node;
        else {
            MyNode<T> currentNode = table[bucket];
            if (checkNodes(node, currentNode)) {
                reWriteNode(node, currentNode);
            }
            else {
                while (currentNode.getNext() != null) {
                    currentNode = currentNode.getNext();
                    if (checkNodes(node, currentNode)) {
                        reWriteNode(node, currentNode);
                        count++;
                        if (!resizeMode)
                            tryResize();
                        return;
                    }
                }
                currentNode.setNext(node);
            }
        }
        count++;
        if (!resizeMode)
            tryResize();
    }

    public boolean remove(T item) {
        int hash = getHash(item);
        int bucket = getIndex(hash);
        MyNode<T> node = new MyNode<T>(hash, item, bucket);
        if (table[bucket] == null)
            return false;
        else {
            MyNode<T> currentNode = table[bucket];
            if (checkNodes(node, currentNode)) {
                deleteNodeFromBucket(bucket, currentNode);
                count--;
                tryResize();
                return true;
            }
            else {
                MyNode<T> prevNode;
                while (currentNode.getNext() != null) {
                    prevNode = currentNode;
                    currentNode = currentNode.getNext();
                    if (checkNodes(node, currentNode)) {
                        deleteNodeFromList(prevNode, currentNode);
                        count--;
                        tryResize();
                        return true;
                    }
                }
                return false;
            }
        }
    }

    private boolean checkNodes(MyNode<T> node, MyNode<T> currentNode) {
        return node.getHash() == currentNode.getHash()
                && node.getItem().equals(currentNode.getItem());
    }

    private void reWriteNode(MyNode<T> node, MyNode<T> currentNode){
        node.setNext(currentNode.getNext());
        currentNode = node;
    }

    private void deleteNodeFromBucket(int bucket, MyNode<T> currentNode) {
        if (bucket != currentNode.getBucket()) {
            System.out.println("Failed delete node from bucket");
            return;
        }
        table[bucket] = table[bucket].getNext();
        currentNode.setNext(null);
    }

    private void deleteNodeFromList(MyNode<T> prevNode, MyNode<T> currentNode) {
        if (prevNode.getNext() != currentNode) {
            System.out.println("Failed delete node from list");
            return;
        }
        prevNode.setNext(currentNode.getNext());
        currentNode.setNext(null);
    }

    private int getHash(T item){
        int hash;
        return item == null ? 0 : (hash = item.hashCode()) ^ (hash >>> 16);
    }

    private int getIndex(int hash){
        return Math.abs(hash % this.capacity);
    }

    @Override
    public Iterator<T> iterator() {
        return new MyHashSetIterator<T>(table);
    }

    private void resize(boolean toUp) {
        var oldTableIterator = this.iterator();
        MyNode<T>[] oldTable = table;
        capacity = toUp ? capacity * 2 : capacity / 2;
        table = new MyNode[this.capacity];
        this.count = 0;
        while (oldTableIterator.hasNext()){
            this.add(oldTableIterator.next());
        }
    }

    private void tryResize() {
        if (count > capacity * fillFactor) {
            resizeMode = true;
            resize(true);
            resizeMode = false;
        }
        else if (count < (capacity / 2) * fillFactor && capacity > DEFAULT_CAPACITY) {
            resizeMode = true;
            resize(false);
            resizeMode = false;
        }
    }

    public int size() {
        return count;
    }

//    public void ensureCapacity(int capacity) {
//        this.capacity = capacity;
//    }
//
//    public void ensureFillFactor(float fillFactor) {
//        this.fillFactor = fillFactor;
//    }
}
