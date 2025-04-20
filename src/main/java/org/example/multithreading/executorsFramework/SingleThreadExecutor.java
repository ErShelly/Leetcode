package org.example.multithreading.executorsFramework;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SingleThreadExecutor {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        Future<Integer> future = executorService.submit(()-> 42);
//        System.out.println(future.get());

        Future<?> future = executorService.submit(() ->  System.out.println("Hello from future!"));

        Thread.sleep(1000);
        if(future.isDone()){
            System.out.println("Task is done!");
        }
        executorService.shutdown();
    }
}
