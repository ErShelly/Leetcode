package org.example.multithreading.locks.synchronizedexample;

public class Test {
    public static void main(String[] args){
        Counter counter = new Counter();
        CounterThread t1 = new CounterThread(counter);
        CounterThread t2 = new CounterThread(counter);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception ex) {

        }
        System.out.println(counter.getCount());
    }
}
