package org.example.binaryTree;

import java.util.Arrays;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {25,10,23,4};
        int h = 4;
        System.out.println(minEatingSpeed(piles, h));
    }


    //Time complexity: O(n∗logm)
    public static int minEatingSpeed(int[] piles, int h) {

        int maxPile = 0;
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }

        int left = 1, right = maxPile, result = maxPile;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Calculate total time with early exit
            long totalTime = 0;
            for (int pile : piles) {
                totalTime += (pile + mid - 1) / mid;
                if (totalTime > h) break;
            }

            if (totalTime <= h) {
                result = mid; // Update result if feasible
                right = mid - 1; // Try smaller speed
            } else {
                left = mid + 1; // Try larger speed
            }
        }
        return result;
    }
}
