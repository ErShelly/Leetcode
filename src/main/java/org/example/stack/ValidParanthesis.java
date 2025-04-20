package org.example.stack;

import java.util.Stack;

public class ValidParanthesis {

    public static void main(String[] args){
        System.out.println(isValid("([{}])"));
    }

    // Time and Space Complexity: O(n)
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                switch(c){
                    case '}':
                        if(stack.peek() != '{') return false;
                        stack.pop();
                        break;

                    case ']':
                        if(stack.peek() != '[') return false;
                        stack.pop();
                        break;

                    case ')':
                        if(stack.peek() != '(') return false;
                        stack.pop();
                        break;
                }
            }
        }

        return stack.isEmpty();
    }
}
