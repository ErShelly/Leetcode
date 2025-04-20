package org.example.multithreading.atomicity;

import org.example.java8.streams.Streams;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//In summary, atomicity ensures operations are performed as a single, uninterrupted action,
// which is critical for maintaining data consistency and preventing race conditions in concurrent programming.
// In Java, atomic variables are part of the java. util. concurrent package
// and are used for concurrent programming to ensure thread safety without explicit synchronization.
class AtomicCounter{
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public void increment(){
        atomicInteger.incrementAndGet();
    }

    public int getCount(){
        return atomicInteger.get();
    }
}
public class AtomicExample {
    public static void main(String[] args) throws InterruptedException {
        AtomicCounter atomicCounter = new AtomicCounter();

        Thread t1 = new Thread(() -> {
            for(int i=0; i<1000; i++){
                atomicCounter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i=0; i<1000; i++){
                atomicCounter.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();;
        t2.join();

        System.out.println("Count: "+atomicCounter.getCount());

        //Cumulative sum example
        //{1,2,3,4,5} --> {1,3,6,10,15}

        AtomicInteger sum = new AtomicInteger(0);
        List<Integer> list = Stream.iterate(1, x-> x+1).limit(5).map(sum::addAndGet).collect(Collectors.toList());
        System.out.println(list);
    }
}
