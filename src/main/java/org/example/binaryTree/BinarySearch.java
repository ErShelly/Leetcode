package org.example.binaryTree;

public class BinarySearch {
    public static void main(String[] args) {
        int nums[] = {-1, 0, 2, 2, 2, 4, 6, 8};
        int target = 2;
        System.out.println(binarySearch(0, nums.length - 1, nums, target));
        System.out.println(binarySearch(nums, target));
        System.out.println(binarySearch2(nums, target));
    }


    //Recursively
    // Time complexity: O(log n)
    // Space complexity :O(log n)
    public static int binarySearch(int start, int end, int[] nums, int target) {
        if (start > end) return -1;
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) return mid;

        if (nums[mid] > target) {
            return binarySearch(start, mid - 1, nums, target);
        } else {
            return binarySearch(mid + 1, end, nums, target);
        }
    }

    // Time complexity: O(log n)
    // Space complexity :O(1)
    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    //upper bound
    // Time complexity: O(log n)
    // Space complexity :O(1)
    public static int binarySearch2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return (left > 0 && nums[left - 1] == target) ? left - 1 : -1;
    }

    //lower bound
    // Time complexity: O(log n)
    // Space complexity :O(1)
    public static int binarySearch3(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return (left < nums.length - 1 && nums[left] == target) ? left : -1;
    }

}
