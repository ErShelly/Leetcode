package org.example.slidingWindow;

public class MinSubarraySum {
    public static void main(String[] args){
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        int res = minSubArrayLen(target, nums);
        System.out.println(res);
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int n=nums.length, window=0, left=0, ans=n+1;

        for(int right=0; right<nums.length; right++){
            window += nums[right];
            while(window >= target){
                ans = Math.min(ans, right-left+1);
                window -= nums[left++];
            }
        }

        return ans > n ? 0 : ans;
    }
}
