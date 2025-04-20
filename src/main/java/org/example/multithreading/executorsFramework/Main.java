package org.example.multithreading.executorsFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(9);

        for (int i = 1; i < 10; i++) {
            int finalI = i;
            Future<?> future = executorService.submit(() -> {
                long res = factorial(finalI);
                System.out.println(res);
            });
        }

        executorService.shutdown();
        try{
            executorService.awaitTermination(1000, TimeUnit.SECONDS);
        } catch (InterruptedException ex){
            throw new RuntimeException(ex);
        }
        System.out.println("Total time taken : " + (System.currentTimeMillis() - startTime));
    }

    private static long factorial(int n) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(ex);
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
