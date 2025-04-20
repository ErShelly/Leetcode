package org.example;

public class MergeSort {

    public static void main(String[] args){
        int[] arr = {6, 3, 9, 5, 2, 8};




    }

    public static void divide(int[] arr, int start, int end) {
        if (arr.length < 2) return;

        int mid = start + (end - start) / 2;
        divide(arr, start, mid);
    }
}
