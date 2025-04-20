package org.example.multithreading.locks.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 1000;

    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " is attempting to withdraw");

        try {
            if (lock.tryLock(2000, TimeUnit.MILLISECONDS)) {
                if (balance >= amount) {
                    try{
                        System.out.println(Thread.currentThread().getName() + " proceeding with withdrawal");
                        Thread.sleep(1000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " completed, remaining bal: "+ balance);
                    } catch (Exception ex){
                        Thread.currentThread().interrupt();
                    } finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + " insufficient balance");
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " couldn't acquire the lock, try again later");
            }
        } catch (Exception ex) {
            Thread.currentThread().interrupt();
        }

    }
}
