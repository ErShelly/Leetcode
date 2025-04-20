package org.example.greedy;

//Leetcode 53
public class MaximumSubarray {
    public static void main(String[] args){
        System.out.println(maxSubArray(new int[]{2,-3,4,-2,2,1,-1,4})); //8
    }

    //Kadane's algorithm
    //Time : O(n)
    //Space : O(1)
    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int curr = 0;

        for(int num:nums){
            if(curr < 0){
                curr = 0;
            }

            curr += num;
            maxSum = Math.max(curr, maxSum);
        }

        return maxSum;
    }
}
