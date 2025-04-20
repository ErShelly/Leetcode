package org.example.intervals;

import java.util.ArrayList;
import java.util.List;

//Leetcode 228
public class SummaryRanges {
    public static void main(String[] args){
        System.out.println(summaryRanges(new int[]{0,1,2,4,5,7}));
    }

    // Time : O(n)
    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        int n = nums.length;
        int start = nums[0];

        for(int i=1; i<n; i++){
            if(nums[i] != nums[i-1]+1){
                if(nums[i-1] == start){
                    res.add(start+"");
                } else {
                    res.add(start+"->"+nums[i-1]);
                }
                start = nums[i];
            }
        }

        if(start == nums[n-1]){
            res.add(start+"");
        } else {
            res.add(start+"->"+nums[n-1]);
        }
        return res;
    }
}
