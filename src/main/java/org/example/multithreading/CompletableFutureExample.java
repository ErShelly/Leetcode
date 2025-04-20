package org.example.multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->{
            try{
                Thread.sleep(4000);
                System.out.println("Worker");
            } catch (InterruptedException ex){

            }
            return "ok";
        });

        completableFuture.get();
        System.out.println("Main");
    }
}
