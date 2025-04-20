package org.example.stack;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args){
        System.out.println(Arrays.toString(asteroidCollision(new int[]{5, 10, -5})));
    }


    //TIme and Space: O(n)
    public static int[] asteroidCollision(int[] asteroids){
        Stack<Integer> stack = new Stack<>();
        for(int asteroid : asteroids){
            boolean destroyed = false;

            while(!stack.isEmpty() && asteroid < 0 && stack.peek() > 0){
                if(Math.abs(asteroid) > stack.peek()){
                    stack.pop();
                    continue;
                } else if(Math.abs(asteroid) == stack.peek()){
                    stack.pop();
                }

                destroyed = true;
                break;
            }

            if(!destroyed) stack.push(asteroid);
        }

        int[] res = new int[stack.size()];
        for(int i=stack.size()-1; i>=0;i--){
            res[i] = stack.pop();
        }

        return res;
    }
}
