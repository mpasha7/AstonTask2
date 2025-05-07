package com.company;

import com.company.mycollections.MyArrayList;
import com.company.mycollections.MyHashSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        list.add(18);
        list.add(53);
        list.add(-99);
        list.add(18);
        list.add(53);
        System.out.println(list);
        System.out.println(list.size());
        System.out.println();

        list.insert(2, 555);
        System.out.println(list);
        System.out.println(list.size());
        System.out.println();

        MyArrayList<Integer> added = new MyArrayList<Integer>();
        added.add(100);
        added.add(300);
        added.add(500);
        list.addAll(added);
        System.out.println(list);
        System.out.println(list.size());
        System.out.println();


        MyArrayList<Integer> deleted = new MyArrayList<Integer>();
        deleted.add(18);
        deleted.add(53);
        System.out.println(list.removeAt(4));
        System.out.println(list.remove(-99));
        System.out.println(list.removeAll(deleted));
        System.out.println(list.removeIf(el -> el > 100));


//        MyHashSet<Integer> set = new MyHashSet<Integer>();
//        set.add(2);
//        set.add(26);
//        set.add(10);
//        set.add(18);
//        set.add(5);
//        set.add(-39);
//        set.add(45); // 7 up -> 16
//        set.add(-17);
//        System.out.println(set.remove(10));
//        System.out.println(set.remove(2));
//        System.out.println(set.remove(5));  // 5 down -> 8
//        System.out.println(set.remove(100));
//        System.out.println(set.remove(-39));
//        System.out.println(set.remove(45));
//        System.out.println(set.remove(26)); // 2
//        System.out.println(set.remove(18));
//        System.out.println(set.remove(-17)); // 0

//        int a = 1;
//        for (int item : set) {
//            System.out.println(item);
//        }
//        System.out.println();

//        MyHashSet<Integer> newset = new MyHashSet<Integer>(set);
//        newset.add(rnd.nextInt() % 1000);
//        newset.add(rnd.nextInt() % 1000);
//        newset.add(rnd.nextInt() % 1000);
//        newset.add(rnd.nextInt() % 1000);
//        newset.add(rnd.nextInt() % 1000);
//        newset.add(rnd.nextInt() % 1000);
//        newset.add(rnd.nextInt() % 1000);
//        newset.add(rnd.nextInt() % 1000);
//        newset.add(rnd.nextInt() % 1000);
//
//        int b = 1;
//        for (int item : newset) {
//            System.out.println(item);
//        }
    }
}
