package org.example.stack;

import java.util.Stack;

public class MinStackCode {
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(2147483646);
        obj.push(2147483646);
        obj.push(2147483647);
        System.out.println(obj.top());     // 2147483647
        obj.pop();
        System.out.println(obj.getMin()); // 2147483646
        obj.pop();
        System.out.println(obj.getMin()); // 2147483646
        obj.pop();
        obj.push(2147483647);
        System.out.println(obj.top());     // 2147483647
        System.out.println(obj.getMin()); // 2147483647
        obj.push(-2147483648);
        System.out.println(obj.top());     // -2147483648
        System.out.println(obj.getMin()); // -2147483648
        obj.pop();
        System.out.println(obj.getMin()); // 2147483647
    }

    static class MinStack {

        Stack<Long> st;
        long minEl;

        public MinStack() {
            st = new Stack<>();
        }

        public void push(int x) {
            long val = x;
            if (st.isEmpty()) {
                minEl = val;
                st.push(val);
                return;
            }

            if (val < minEl) {
                st.push(2 * val - minEl);
                minEl = val;

            } else {
                st.push(val);
            }
        }

        public void pop() {
            if (st.isEmpty()) {
                return;
            }
            long y = st.peek();
            if (y < minEl) {
                minEl = 2 * minEl - y;
            }
            st.pop();
        }

        public int top() {
            if (st.isEmpty()) {
                return -1;
            }

            long y = st.peek();
            if (y < minEl) {
                return (int) minEl;
            }
            return (int) y;
        }

        public int getMin() {
            if (st.isEmpty()) {
                return -1;
            }
            return (int) minEl;
        }
    }
}




