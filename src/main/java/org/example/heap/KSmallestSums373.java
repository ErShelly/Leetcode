package org.example.heap;

import java.util.*;

public class KSmallestSums373 {
    public static void main(String[] args) {
        int[] nums1 = {1, 7};
        int[] nums2 = {2, 3};
        int k = 3;

        List<List<Integer>> result = kSmallestPairs(nums1, nums2, k);
        System.out.println("K Smallest Pairs with smallest sums:");
        for (List<Integer> pair : result) {
            System.out.println(pair);
        }
    }

    //Time: O(min(k, m) + k × log(min(k, m)))
    //Space :
    //Heap size: O(min(m, k))
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0 || k == 0) return res;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0] + a[1]));
        //PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) ->
        //            Integer.compare(a[0] + a[1], b[0] + b[1])
        //        );

        for(int i=0; i< Math.min(k,nums1.length); i++){
            minHeap.offer(new int[]{nums1[i], nums2[0], 0});
        }

        while(k > 0 && !minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            int num1 = curr[0], num2 = curr[1], idx =curr[2];
            res.add(Arrays.asList(num1, num2));
            k--;

            if(idx + 1< nums2.length){
                minHeap.offer(new int[]{num1, nums2[idx+1], idx+1});
                idx++;
            }
        }

        return res;
    }
}
