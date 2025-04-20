package org.example.backtracking;

import java.util.ArrayList;
import java.util.List;

//Time complexity = O(n*2^n)
//Space = O(n)
// Output list =  O(2^n)

public class Subsets78 {
    public static void main(String[] args){
        Subsets78 subsets78 = new Subsets78();
        System.out.println(subsets78.subsets(new int[]{1,2,3}));
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        dfs(res, subset, 0, nums);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> subset,
                     int i, int[] nums) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        dfs(res, subset, i + 1, nums);
        subset.remove(subset.size() - 1);
        dfs(res, subset, i + 1, nums);
    }
}
