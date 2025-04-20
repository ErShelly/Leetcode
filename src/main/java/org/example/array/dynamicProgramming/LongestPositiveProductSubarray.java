package org.example.array.dynamicProgramming;

public class LongestPositiveProductSubarray {
    public static void main(String[] args) {
        int[] nums = {0, 1, -2, -3, -4};
        maxLen(nums);

    }

    private static void maxLen(int[] arr) {
        int posLength = 0, negLength = 0, maxLength = 0;

        for (int num : arr) {
            if (num > 0) {
                posLength += 1;
                if (negLength > 0) {
                    negLength += 1;
                } else {
                    negLength = 0;
                }
            } else if(num < 0){
                int temp = posLength;
                if(negLength > 0){
                    posLength = negLength + 1;
                } else {
                    posLength = 0;
                }
                negLength = temp + 1;
            } else {
                posLength = 0;
                negLength = 0;
            }

            maxLength = Math.max(maxLength, posLength);
        }

        System.out.println("MaxLength: "+maxLength);

    }
}
