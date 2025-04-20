package org.example.multithreading;

import org.example.multithreading.locks.reentrantlock.BankAccount;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();

        //anonymous class
        Runnable task = new Runnable() {
            @Override
            public void run() {
                bankAccount.withdraw(500);
            }
        };
        Thread t1 = new Thread(task, "Thread1");
        Thread t2 = new Thread(task, "Thread2");
        t1.start();
        t2.start();

    }
}
