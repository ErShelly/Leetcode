package org.example.multithreading.locks.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

public class RenentrantExample {
    private final Lock lock = new ReentrantLock();

    public void outerMethod() {
        lock.lock();
        try {
            System.out.println("Outer Method");
            innerMethod();
        } finally {
            lock.unlock();
        }
    }

    public void innerMethod() {
        lock.lock();
        try {
            System.out.println("Inner method");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        RenentrantExample rn = new RenentrantExample();
        rn.outerMethod();
    }
}
