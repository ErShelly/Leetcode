package org.example.array;

public class Bitonic {
    public static void main(String[] args) {
        int arr[] = {1, 15, 25, 45, 42, 21, 17, 12, 11};
        int length = arr.length;
        int bitonicNum = binarySearch(arr, 1, length-2);
        System.out.println(bitonicNum);
    }

    public static int binarySearch(int[] arr, int left, int right) {
        if (left <= right) {
            ;
            int mid = (left + right) / 2;

            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                return arr[mid];
            }

            if (arr[mid] < arr[mid + 1]) {
                return binarySearch(arr, mid + 1, right);
            } else {
                return binarySearch(arr, left, mid - 1);
            }
        }

        return -1;
    }
}
