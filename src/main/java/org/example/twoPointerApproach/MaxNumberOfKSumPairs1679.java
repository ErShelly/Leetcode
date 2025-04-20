package org.example.twoPointerApproach;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfKSumPairs1679 {
    public static void main(String[] args){
        System.out.println(maxOperations(new int[]{1,2,3,4},5));
    }

    public static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);

        int i=0,j=nums.length-1;
        int res = 0;
        while(i<j){
            int sum = nums[i] + nums[j];
            if(sum == k){
                res++;
                i++;
                j--;
            } else if(sum<k){
                i++;
            } else{
                j--;
            }
        }
        return res;


    }

    public static int maxOperations2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int pairs = 0;

        for(int i=0; i<nums.length; i++){
            int remaining = k - nums[i];

            if(map.getOrDefault(remaining, 0) > 0){
                pairs++;
                map.put(remaining, map.get(remaining) - 1);
            } else {
                map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            }
        }

        return pairs;
    }
}
