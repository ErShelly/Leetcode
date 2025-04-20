package org.example.array;

import java.util.Arrays;

public class CountTheTriplets {
    public static void main(String[] args){
        int arr[] = {1,5,3,2};
        countTriplets(arr);
    }

    public static void countTriplets(int[] arr){
        if(arr.length < 3) return;

        Arrays.sort(arr);
        int n = arr.length;

        int count = 0;
        for(int i=n-1;i>=0;i--){
            int j=0;
            int k=i-1;
            while(j<k){
                int sum = arr[j] + arr[k];
                if(sum == arr[i]){
                    count++;
                    j++;
                    k--;
                } else if(arr[i] > sum){
                    j++;
                } else {
                    k--;
                }
            }
        }
        System.out.println(count);
    }
}
