package org.example.multithreading.executorsFramework;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExample {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
//        scheduledExecutorService.schedule(
//                ()-> System.out.println("Task executed after 5 seconds delay"),
//                5,
//                TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(
                () -> System.out.println("Eexcuted after 5 seconds"),
                5,
                2,
                TimeUnit.SECONDS
        );

        ScheduledFuture<?> future = scheduledExecutorService.scheduleWithFixedDelay(
                () -> System.out.println("Executed after 2 seconds delay"),
                5,
                2,
                TimeUnit.SECONDS
        );

        scheduledExecutorService.schedule(() -> {
                    System.out.println("shutting down");
                    scheduledExecutorService.shutdown();
                },
                20,
                TimeUnit.SECONDS
        );
    }
}
