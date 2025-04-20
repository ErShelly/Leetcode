package org.example.array;

public class MaxSubArray {
    public static void main(String[] args){

        int[] arr = {-1, -2, -3, -2, -5};
        int n = 5;

//        //print all combinations
        for(int st=0;st<n;st++){
            for(int end=st; end<n;end++) {
                for (int j = st; j <= end; j++) {
                    System.out.print(arr[j]);
                }
                System.out.println(" ");
            }
        }

        //brute force
        int maxSum1 = Integer.MIN_VALUE;
        for(int st=0; st<n; st++) {
            int currentSum = 0;
            for (int end = st; end < n; end++) {
                currentSum += arr[end];
                if (currentSum > maxSum1) {
                    maxSum1 = currentSum;
                }
            }
        }
        System.out.println("Brute force: " + maxSum1);

        //Kadane's algorithm
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for(int i=0;i<n;i++){
            currentSum = currentSum + arr[i];
            if(currentSum > maxSum){
                maxSum = currentSum;
            }

            if(currentSum < 0){
                currentSum = 0;
            }
        }

        System.out.println("MaxSum:" + maxSum);
    }
}
