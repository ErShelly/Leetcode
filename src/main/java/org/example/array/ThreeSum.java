package org.example.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        //Leetcode 15. 3Sum
        threeSum(nums, 0);
    }

    public static void threeSum(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();

        int n = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < n-2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if(sum == target){
                    List<Integer> list = Arrays.asList(arr[i], arr[j], arr[k]);
                    j++;
                    k--;

                    res.add(list);
                    while(j<n && arr[j] == arr[j-1]) j++;
                    while(k>j && arr[k] == arr[k+1]) k--;
                } else if(sum < target){
                    j++;
                } else {
                    k--;
                }
            }
        }

        for(List<Integer> l : res){
            System.out.println(Arrays.toString(l.toArray()));
        }
    }

}
