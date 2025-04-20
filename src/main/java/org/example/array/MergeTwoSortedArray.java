package org.example.array;

import java.util.Arrays;

public class MergeTwoSortedArray {
    public static void main(String[] args){
        int a[] = {1, 3, 5, 7};
        int b[] = {0,2,6, 8, 9};

        mergeArrays(a,b);

    }
    public static void mergeArrays(int a[], int b[]) {
        int n = a.length;
        int m = b.length;
        if(a[n-1] < b[0]) return;

        int i = n-1;
        int j=0;
        while(i>=0 && j<m){
            if(b[j] < a[i]){
                int temp = a[i];
                a[i] = b[j];
                b[j] = temp;
            }
            i--;
            j++;
        }
        Arrays.sort(a);
        Arrays.sort(b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
}
