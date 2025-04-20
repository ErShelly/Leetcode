package org.example.multithreading;


class SharedResource {
    private int data;
    private boolean hasData;

    public synchronized void produce(int value) {
        try {
            while (hasData) {
                wait();
            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        data = value;
        hasData = true;
        System.out.println("Produced " + value);
        notify();
    }

    public synchronized int consume() {
        try {
            while (!hasData) {
                wait();
            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        hasData = false;
        System.out.println("Consumed " + data);
        notify();

        return data;
    }
}

class Producer implements Runnable {
    private SharedResource sharedResource;

    public Producer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            sharedResource.produce(i);
        }
    }
}

class Consumer implements Runnable {
    private SharedResource sharedResource;

    public Consumer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int value = sharedResource.consume();
        }
    }
}

public class ThreadCommunication {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread t1 = new Thread(new Producer(resource), "ProducerThread");
        Thread t2 = new Thread(new Consumer(resource), "ConsumerThread");

        t1.start();
        t2.start();
    }
}
