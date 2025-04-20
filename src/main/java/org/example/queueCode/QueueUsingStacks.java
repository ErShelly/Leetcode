package org.example.queueCode;

import java.util.Stack;

public class QueueUsingStacks {
    static class Queue{
        Stack<Integer> st1  = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        public boolean isEmpty(){
            if(st1.isEmpty() && st2.isEmpty()){
                return true;
            }
            return false;
        }
        public void add(int data){
            while (!st1.empty()){
                st2.push(st1.pop());
            }
            st1.push(data);
            while(!st2.isEmpty()){
                st1.push(st2.pop());
            }
        }

        public int remove(){
            if(isEmpty()){
                return -1;
            }

            return st1.pop();
        }

        public int peek(){
            if(isEmpty()){
                return -1;
            }

            return st1.peek();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()){
            System.out.println(q.remove());
        }
    }
}
