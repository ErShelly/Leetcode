package org.example.multithreading;

public class LambdaExpression {

    public static void main(String[] args) {
        //Runnable runnable = () -> System.out.println("hello");
//        Thread t1 = new Thread(() -> System.out.println("Hello"), "T1");
//        t1.start();

        Thread t1 = new Thread(() -> {
           for(int i=0; i<10;i++){
               System.out.println("Hello");
           }
        }, "t1");

        t1.start();

    }
}
