package org.example.prefixSum;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1); // Initialize with (0,1) to handle exact k matches

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num; // Update the prefix sum

            // Check if there exists a prefix sum that would make a subarray sum k
            if (sumMap.containsKey(prefixSum - k)) {
                count += sumMap.get(prefixSum - k);
            }

            // Store/update the prefix sum in the map
            sumMap.put(prefixSum, sumMap.getOrDefault(prefixSum, 0) + 1);
        }

        return count;

    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 3};
        int k = 3;
        System.out.println("Number of subarrays with sum " + k + ": " + subarraySum(nums, k));
        // Output: 3
    }
}
