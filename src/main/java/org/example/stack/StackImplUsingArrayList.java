package org.example.stack;

import java.util.ArrayList;
import java.util.Stack;

public class StackImplUsingArrayList {
    static class Stack {
        ArrayList<Integer> list = new ArrayList<>();

        public boolean isEmpty() {
            return list.size() == 0;
        }

        public void push(int data) {
            list.add(data);
        }

        public int pop() {
            if (list.isEmpty()) {
                return -1;
            }
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        public int peek() {
            if (list.isEmpty()) {
                return -1;
            }

            return list.get(list.size() - 1);
        }
    }

    public static void main(String[] args) {
//        Stack st = new Stack();
        java.util.Stack<Integer> st = new java.util.Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);

        while (!st.isEmpty()) {
            System.out.println(st.peek());
            st.pop();
        }
    }
}
