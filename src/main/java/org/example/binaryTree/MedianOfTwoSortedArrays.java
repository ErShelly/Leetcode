package org.example.binaryTree;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int nums1[] = {1, 3};
        int nums2[] = {2, 4};
        System.out.println(findMedian(nums1, nums2));
    }

    //Time complexity: O(n+m)log(n+m)
    public static double findMedian(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int length = len1+len2;
        int[] merged = new int[length];

        System.arraycopy(nums1, 0, merged, 0, len1);
        System.arraycopy(nums2, 0, merged, len1, len2);

        Arrays.sort(merged);

        if(length%2 == 0){
            return (merged[(length/2)-1] + merged[length/2])/2.0;
        } else {
            return merged[length/2];
        }
    }
}
