package org.example.multithreading.locks.synchronizedexample;

public class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for(;;){
            System.out.println("Hello from:"+ Thread.currentThread().getName());
        }
    }

    public static void main(String[] args){
        MyThread t1 = new MyThread("t1");
        MyThread t2 = new MyThread("t2");

        t1.setDaemon(true);

        System.out.println("Main:");
        t2.start();
        t1.start();
        System.out.println("Main:");
    }
}
