package org.example.multithreading.executorsFramework;

import java.util.concurrent.*;

public class FutureMethods {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(() -> {
            try{
                Thread.sleep(2000);
            } catch (InterruptedException ex){
                System.out.println("Exception " + ex);
            }
            System.out.println("Hello");
            return 42;
        });
        try{
            Thread.sleep(1000);
        } catch (InterruptedException ex){
            System.out.println(ex);
        }
        future.cancel(false);
        System.out.println(future.isCancelled());
        System.out.println(future.isDone());
//        Integer i = null;
//        try {
//            System.out.println(future.isDone());
//            i = future.get(1, TimeUnit.SECONDS);
//            System.out.println(future.isDone());
//            System.out.println(i);
//        } catch (InterruptedException | ExecutionException | TimeoutException ex) {
//            System.out.println("Exception " + ex);
//        }
        executorService.shutdown();
    }
}
