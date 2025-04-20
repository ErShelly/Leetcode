package org.example.slidingWindow;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//leetcode 239
public class SlidingWindowMaximum {

    public static void main(String[] args){
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        System.out.println(Arrays.toString(slidingWindowMaximum.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    //Time : O(n*k)
    public int[] maxSlidingWindowBruteForce(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];

        int s=0;
        for(int i=0;i<=n-k; i++){
            int maxi = nums[i];
            for(int j=i; j<i+k;j++){
                maxi = Math.max(maxi, nums[j]);
            }
            res[s++] = maxi;
        }

        return res;
    }

    // Time & Space : O(n)
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n-k+1];
        Deque<Integer> queue = new LinkedList<>();
        int l=0,r=0;

        while(r<n){
            while(!queue.isEmpty() && nums[queue.getLast()] < nums[r]){
                queue.removeLast();
            }

            queue.addLast(r);
            if(l > queue.getFirst()){
                queue.removeFirst();
            }

            if((r+1) >= k){
                output[l] = nums[queue.getFirst()];
                l++;
            }
            r++;
        }

        return output;
    }
}
