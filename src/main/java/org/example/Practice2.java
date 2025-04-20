package org.example;

public class Practice2 {
    public static void main(String[] args){
        int n = 5;
        int[] arr = {-1, -2, -3, -4, -5};
        printAllCombinations(arr);
        maxSubArr(arr);
        maxSubArrayUsingkadane(arr);
    }

    //print all subarray combinations
    private static void printAllCombinations(int[] arr){
        for(int st=0;st<arr.length;st++){
            for(int end=0;end<arr.length;end++){
                for(int j=st;j<=end;j++){
                    System.out.print(arr[j]);
                }
                System.out.println();
            }
        }
    }

    //max subarray brute force
    private static void maxSubArr(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int st=0;st<arr.length;st++){
            int currentSum = 0;
            for(int end=st;end<arr.length;end++){
                currentSum += arr[end];
                max = Math.max(currentSum, max);
            }
        }

        System.out.println("Max: "+max);
    }

    //kadane's algo
    private static void maxSubArrayUsingkadane(int[] arr){
        int max = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i=0; i<arr.length; i++){
            currSum += arr[i];
            max = Math.max(currSum, max);

            if(currSum < 0){
                currSum = 0;
            }
        }
        System.out.println("Max using Kadane's: "+max);
    }
}
