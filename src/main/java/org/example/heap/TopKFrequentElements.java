package org.example.heap;

import java.util.*;

class TopKFrequentElements {
    // time complexity: O(n log k)
    // Space: O(n)
    public int[] topKFrequent(int[] nums, int k) {
        // Build frequency map
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Min Heap (PriorityQueue) to keep top k frequent elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                (a, b) -> countMap.get(a) - countMap.get(b)
        );

        for (int key : countMap.keySet()) {
            minHeap.offer(key);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Build result array from the heap
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = minHeap.poll();
        }

        return res;
    }

    public static void main(String[] args) {
        TopKFrequentElements sol = new TopKFrequentElements();

        // Example test case:
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        int[] result = sol.topKFrequent(nums, k);
        System.out.println("Top " + k + " frequent elements: " + Arrays.toString(result));

        // You can add more test cases if needed.
    }
}

