package org.example.twoPointerApproach;

public class TappingRainWater {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public int trap(int[] height) {
        if (height == null || height.length < 3) return 0;

        int l = 0, r = height.length - 1;
        int leftMax = height[l], rightMax = height[r];
        int res = 0;

        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                res += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                res += rightMax - height[r];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TappingRainWater tappingRainWater = new TappingRainWater();
        System.out.println(tappingRainWater.trap(new int[]{4, 2, 0, 3, 2, 5}));
    }
}
