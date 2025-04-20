package org.example.binaryTree;

public class SearchMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 30;
        System.out.println(searchMatrix2(matrix, target));
        System.out.println(searchMatrix(matrix, target));
    }

    //time complexity: O(Mlogn)
    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int[] arr : matrix) {
            if (target <= arr[arr.length - 1]) {
                boolean res = binarySearch(arr, target);
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean binarySearch(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = end + (start - end) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    //Time complexity : O(log m* log n)
    public static boolean searchMatrix2(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int l = 0;
        int r = rows * cols - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int row = mid / cols;
            int col = mid % cols;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
}