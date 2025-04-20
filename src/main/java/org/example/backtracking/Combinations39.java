package org.example.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations39 {


    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>());
        return res;
    }

//    Summary:
//    The code explores both include and exclude options at every step.
//    No pruning means it may go deeper even after exceeding the target.
//    All combinations where the sum is exactly the target are added.

//    Worst Case Time: O(2^t/m) //At each level, you either include or exclude., So you can end up exploring 2^T paths.
//    Space Complexity:
//    O(t/m) recursion stack
    ////Where t is the given target and m is the minimum value in nums.
//    O(# of valid combinations × avg size) for result storage
    //
    public void dfs(int[] candidates, int target, int i, List<Integer> curr) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (target < 0 || i >= candidates.length) {
            return;
        }

        curr.add(candidates[i]);
        dfs(candidates, target - candidates[i], i, curr);
        curr.remove(curr.size() - 1);
        dfs(candidates, target, i + 1, curr);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<>());
        return res;
    }

    //Improves performance significantly
    //Reduces number of recursive calls
    //Prevents going down invalid paths

    //Worst Case Time: O(2^t/m) //At each level, you either include or exclude., So you can end up exploring 2^T paths.
    //    Space Complexity:
//    O(t/m) recursion stack
    //Where t is the given target and m is the minimum value in nums.
    public void dfs2(int[] candidates,int total, int target, int i, List<Integer> curr){
        if(total == target){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int j=i; j<candidates.length; j++){
            if(total + candidates[j] > target){
                return;
            }

            curr.add(candidates[j]);
            dfs2(candidates, total + candidates[j], target,  j, curr);
            curr.remove(curr.size() - 1);
        }

    }

}
