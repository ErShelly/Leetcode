package org.example.multithreading.locks.synchronizedexample;

public class Counter {
    private int count = 0;

    public void increment(){
        synchronized(this){
            count++;
        }
    }

    public int getCount(){
        return count;
    }
}
