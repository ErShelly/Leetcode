package org.example.queueCode;

public class ImplUsingArray {
    static class Queue {
        int[] arr;
        int size;
        int rear = -1;

        Queue(int n) {
            arr = new int[n];
            this.size = n;
        }

        public boolean isEmpty() {
            return rear == -1;
        }

        //enqueue
        public void add(int data) {
            if (rear == size - 1) {
                System.out.println("Queue is full");
                return;
            }

            rear++;
            arr[rear] = data;
        }

        //dequeue
        public int remove() {
            if (isEmpty()) {
                return -1;
            }

            int front = arr[0];
            for (int i = 1; i <= rear; i++) {
                arr[i - 1] = arr[i];
            }

            rear--;
            return front;
        }

        public int peek() {
            if (isEmpty()) {
                return -1;
            }
            int front = arr[0];
            return front;
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(20);
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
