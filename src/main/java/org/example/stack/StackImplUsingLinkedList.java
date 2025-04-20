package org.example.stack;

public class StackImplUsingLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stack {
        public static Node head;

        public static boolean isEmpty() {
            if (head == null) {
                return true;
            }
            return false;
        }

        public static void push(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }

            newNode.next = head;
            head = newNode;
        }

        public static int pop() {
            if(isEmpty()){
                return -1;
            }

            if(head.next == null){
                head = null;
                return -1;
            }

            int popHead = head.data;
            head = head.next;
            return popHead;
        }

        public static int peek(){
            if(isEmpty()){
                return -1;
            }

            int top = head.data;
            return top;
        }
    }

    public static void main(String[] args) {
        Stack.push(1);
        Stack.push(2);
        Stack.push(3);
        Stack.push(4);

        while (!Stack.isEmpty()){
            System.out.println(Stack.peek());
            Stack.pop();
        }
    }
}
