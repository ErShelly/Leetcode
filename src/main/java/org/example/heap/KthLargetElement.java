package org.example.heap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargetElement {
    public static void main(String[] args) {
//        KthLargest2 kthLargest = new KthLargest2(3, new int[]{1, 2, 3, 3});
//        System.out.println(kthLargest.add(3));
//        System.out.println(kthLargest.add(5));
//        System.out.println(kthLargest.add(6));
//        System.out.println(kthLargest.add(7));
//        System.out.println(kthLargest.add(8));

        System.out.println(kthLargestUsingQuickSelect(2, new int[]{3,2,1,4,6,5}));
    }

    private static int kthLargestUsingQuickSelect(int k, int[] arr) {
        return quickSelect(arr, 0, arr.length - 1, k);
    }

    //Time complexity:
    //O(n) in average case,

    //O(n^2) in worst case.
    //Space complexity:
    //O(n)
    private static int quickSelect(int[] nums, int left, int right, int k) {
        int pivot = nums[right];
        int p = left;

        for (int i = left; i < right; i++) {
            if (nums[i] <= pivot) {
                int temp = nums[p];
                nums[p] = nums[i];
                nums[i] = temp;
                p++;
            }
        }

        int temp = nums[p];
        nums[p] = nums[right];
        nums[right] = temp;

        if (p > k) {
            return quickSelect(nums, left, p - 1, k);
        } else if (p < k) {
            return quickSelect(nums, p + 1, right, k);
        } else {
            return nums[p];
        }
    }
}

// Time complexity:O(m*nlog n)
// Space complexity: O(1) or O(n) depending on the sorting algorithm.
//Where m is the number of calls made to add() and n is the current size of the array.
class KthLargest {
    ArrayList<Integer> arr;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.arr = new ArrayList<>();
        for (int num : nums) {
            arr.add(num);
        }
    }

    public int add(int value) {
        arr.add(value);
        Collections.sort(arr);
        return arr.get(arr.size() - k);
    }
}

//Efficient
// Time complexity:O(m*log k) (since the heap size is limited to k)
// Space complexity: O(k)
class KthLargest2 {
    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargest2(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }

    public int add(int value) {
        minHeap.offer(value);
        if (minHeap.size() > k) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}