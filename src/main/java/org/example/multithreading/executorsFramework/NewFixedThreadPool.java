package org.example.multithreading.executorsFramework;

import java.util.List;
import java.util.Arrays;
import java.util.concurrent.*;

public class NewFixedThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Callable<Integer> callable1 = () -> {
            Thread.sleep(1000);
            System.out.println("Task1");
            return 1;
        };

        Callable<Integer> callable2 = () -> {
            Thread.sleep(1000);
            System.out.println("Task2");
            return 2;
        };
        Callable<Integer> callable3 = () -> {
            Thread.sleep(1000);
            System.out.println("Task3");
            return 3;
        };

        List<Callable<Integer>> list = Arrays.asList(callable1, callable2, callable3);
        try {
            Integer i = executorService.invokeAny(list);
            System.out.println(i);
//            List<Future<Integer>> futures = executorService.invokeAll(list, 2, TimeUnit.SECONDS);
//            for (Future<Integer> f : futures) {
//                System.out.println(f.get());
//            }
        } catch (CancellationException ex){

        }

        executorService.shutdown();
        System.out.println("DONE");
        //        Future<Integer> futureRes = executorService.submit(()-> 1+2);
//        Integer i = futureRes.get();
//        System.out.println(i);
//        Thread.sleep(1);
//        System.out.println(executorService.isTerminated());

    }

}
