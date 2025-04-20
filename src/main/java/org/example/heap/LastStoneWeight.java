package org.example.heap;

import java.util.PriorityQueue;

public class LastStoneWeight {

    //Time: O(nlogn)
    //Space: O(n)
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() > 1) {
            int y = maxHeap.poll();
            int x = maxHeap.poll();

            if (x != y) {
                maxHeap.add(y - x); // Push the difference back
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

    public static void main(String[] args) {
        LastStoneWeight solver = new LastStoneWeight();
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(solver.lastStoneWeight(stones)); // Output: 1
    }
}