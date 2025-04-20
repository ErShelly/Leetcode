package org.example.twoPointerApproach;

public class ContainerWithMostWater11 {
    public static void main(String[] args){
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7})); //49
    }
    public static int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;

        int maxArea = 0;

        while(left < right){
            int minH = Math.min(heights[left], heights[right]);
            int area = minH * (right-left);
            maxArea = Math.max(maxArea, area);

            while(left<right && heights[left] <= minH) left++;
            while(right>left && heights[right] <= minH) right--;

        }

        return maxArea;
    }
}
