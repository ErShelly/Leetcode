package org.example.heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

//Leetcode 502
public class IPO {
    public static void main(String[] args) {
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 1};
        int k = 2;
        int w = 0;
        System.out.println(findMaximizedCapital(k, w, profits, capital));
    }

    //Time: O(nlongn)
    // Space: O(n)
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> minHeapCapital = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> maxHeapProfits = new PriorityQueue<>((a,b) -> b-a);

        for (int i = 0; i < capital.length; i++) {
            minHeapCapital.offer(new int[]{capital[i], profits[i]});
        }

        for (int i = 0; i < k; i++) {
            while (!minHeapCapital.isEmpty() && minHeapCapital.peek()[0] <= w){
                maxHeapProfits.offer(minHeapCapital.peek()[1]);
            }

            if(maxHeapProfits.isEmpty()){
                break;
            }

            w += maxHeapProfits.poll();
        }

        return w;
    }
}
