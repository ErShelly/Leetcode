package org.example.multithreading.locks.fairlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairLockExample {
    private final Lock lock = new ReentrantLock(true);

    public void accessResource() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " acquire");
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(Thread.currentThread().getName() + " release");
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        FairLockExample fairLockExample = new FairLockExample();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                fairLockExample.accessResource();
            }
        };

        Thread t1 = new Thread(task, "t1");
        Thread t2 = new Thread(task, "t2");
        Thread t3 = new Thread(task, "t3");

        t1.start();
        t2.start();
        t3.start();
    }
}
