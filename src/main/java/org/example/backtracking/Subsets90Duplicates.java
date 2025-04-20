package org.example.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets90Duplicates {
    public static void main(String[] args){
        Subsets78 subsets78 = new Subsets78();
        System.out.println(subsets78.subsets(new int[]{1,2,2}));
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        Arrays.sort(nums);

        dfs(res, subset, 0, nums);
        return res;
    }


//Time complexity = O(n*2^n)
//Space = O(n)
// Output list =  O(2^n)
    private void dfs(List<List<Integer>> res, List<Integer> subset, int i, int[] nums){
        if(i>=nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        dfs(res, subset, i+1, nums);
        subset.remove(subset.size()-1);
        while(i+1<nums.length && nums[i] == nums[i+1]){
            i++;
        }

        dfs(res, subset, i+1, nums);
    }
}
