package org.example.dynamicProgramming;

public class ClimbStairs {
    public static void main(String[] args){
        System.out.println(climbStairs(5)); //8 is the answer
    }

    // Time & Space O(n)
    public static int climbStairs(int n){
        if(n==1 || n==2) return n;

        int[] dp = new int[n+1];

        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }


    // Time : O(n) , Space: O(1)
    public int climbStairs2(int n) {
        //f(n) = f(n-1) + f(n-2);

        int one = 1; //f(n-1);
        int two = 1; //f(n-2);

        for(int i=1;i<n;i++){
            int temp = one;
            one = one + two;
            two = temp;
        }

        return one;
    }
}
