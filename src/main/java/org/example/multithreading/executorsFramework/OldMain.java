package org.example.multithreading.executorsFramework;

public class OldMain {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Thread[] threads = new Thread[9];
        for (int i = 1; i < 10; i++) {
            int finalI = i;
            threads[i - 1] = new Thread(() -> {
                long res = factorial(finalI);
                System.out.println(res);
            });
            threads[i - 1].start();
        }
        for (Thread th : threads) {
            try {
                th.join();
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
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
