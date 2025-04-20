package org.example.stack;

import java.util.Stack;

public class ReversePolishNotation {
    public static void main(String[] args){
        String[] arr = {"2","1","+","3","*"};
        System.out.println(evalRPN(arr));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+") || s.equals("*") || s.equals("-") || s.equals("/")) {
                int y = stack.pop();
                int x = stack.pop();
                switch (s) {
                    case "+":
                        stack.push(x+y);
                        break;

                    case "-":
                        stack.push(x-y);
                        break;

                    case "*":
                        stack.push(x*y);
                        break;

                    case "/":
                        stack.push(x/y);
                        break;
                }
            } else {
                stack.push(Integer.valueOf(s));
            }

        }
        return stack.pop();
    }
}
