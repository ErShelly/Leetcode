package org.example.hashmap;

import java.util.concurrent.atomic.AtomicInteger;

public class CASExample {
    public static void main(String[] args){
        AtomicInteger atomicInt = new AtomicInteger(5);

        int expectedValue = 5;
        int newValue = 10;

        boolean success = atomicInt.compareAndSet(expectedValue, newValue);
        System.out.println(success);
    }
}
