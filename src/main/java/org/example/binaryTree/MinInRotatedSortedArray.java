package org.example.binaryTree;

public class MinInRotatedSortedArray {
    public static void main(String[] args) {
        int nums[] = {3, 4, 5, 6, 1, 2};
        System.out.println(findMin2(nums));

    }


    //Time complexity: O(log n)
    public static int findMin(int[] arr) {
        int left = 0, right = arr.length - 1;
        int min = arr[0];

        while (left <= right) {
            if (arr[left] < arr[right]) {
                min = Math.min(min, arr[left]);
                break;
            }

            int mid = left + (right - left) / 2;
            min = Math.min(min, arr[mid]);
            if (arr[mid] >= arr[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return min;
    }

    public static int findMin2(int[] arr){
        int left=0, right=arr.length-1;
        int min=arr[0];
        while(left<=right){
            if(arr[left] < arr[right]){
                min = Math.min(min, arr[left]);
                break;
            }

            int mid = left + (right - left)/2;
            min=Math.min(min, arr[mid]);
            if(arr[mid] < arr[right]){
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return min;
    }
}
