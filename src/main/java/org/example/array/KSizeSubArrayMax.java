package org.example.array;

import java.util.*;

public class KSizeSubArrayMax {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k = 3;

        System.out.println(maxSubArray(arr, k));
        System.out.println(maxSubArraySlidingWindow(arr, k));
    }

    public static ArrayList<Integer> maxSubArray(int[] arr, int k) {
        ArrayList<Integer> resArr = new ArrayList<>();
        int j, max;
        int n = arr.length;
        for (int i = 0; i <= n - k; i++) {
            max = arr[i];
            for (j = 1; j < k; j++) {
                if (arr[i + j] > max) {
                    max = arr[i + j];
                }
            }
            resArr.add(max);
        }

        return resArr;
    }

    public static ArrayList<Integer> maxSubArraySlidingWindow(int[] arr, int k){
        ArrayList<Integer> list = new ArrayList<>();
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        for(int i=0; i<arr.length; i++){
            while(!arrayDeque.isEmpty() && arr[arrayDeque.getLast()] < arr[i]){
                arrayDeque.removeLast();
            }

            arrayDeque.addLast(i);

            if(arrayDeque.getFirst() + k == i){
                arrayDeque.removeFirst();
            }

            if(i >= k - 1){
                list.add(arr[arrayDeque.getFirst()]);
            }
        }
        return list;
    }
}
