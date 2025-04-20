package org.example.multithreading;

import java.util.concurrent.*;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        int numberOfServices = 3;
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfServices);

        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));

        //latch.await();
        latch.await(4, TimeUnit.SECONDS);

        System.out.println("main");
        executorService.shutdown();
    }
}

class DependentService implements Callable<String> {
    private final CountDownLatch latch;

    public DependentService(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public String call() throws Exception {
        try {
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + " Service started ... ");
        } finally {
            latch.countDown();
        }

        return "ok";
    }
}
