package org.example.heap;

import java.util.PriorityQueue;

public class KthLargestElementInStream {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargestElementInStream(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        for(int num:nums){
            add(num);
        }
    }

    public int add(int val) {
        minHeap.offer(val);
        if(minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }

    public static void main(String[] args){
        KthLargestElementInStream kthLargestElement = new KthLargestElementInStream(3, new int[]{1,2,3,3});
        System.out.println(kthLargestElement.add(3));
        System.out.println(kthLargestElement.add(3));
        System.out.println(kthLargestElement.add(5));
        System.out.println(kthLargestElement.add(6));
    }
}
