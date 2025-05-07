package com.company.mycollections;

public class NextIsNullException extends Exception {

    public NextIsNullException() {
        super("Next item is null");
    }
}
