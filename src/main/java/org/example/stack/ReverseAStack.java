package org.example.stack;

import java.util.Stack;

public class ReverseAStack {
    public static void reverse(Stack<Integer> st) {
        if(st.isEmpty()){
            return;
        }

        int top = st.pop();
        reverse(st);
        pushAtBottom(top, st);
    }

    public static void pushAtBottom(int data, Stack<Integer> stack){
        if(stack.isEmpty()){
            stack.push(data);
            return;
        }

        int top = stack.pop();
        pushAtBottom(data, stack);
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);

        reverse(st);
        while (!st.isEmpty()){
            System.out.println(st.pop());
        }
    }
}
