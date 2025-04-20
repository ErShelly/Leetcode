package org.example;

import java.util.Arrays;

public class Practice {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        int[] arr = product(nums);
        for (int num : arr) {
            System.out.println(num);
        }
    }

    public static int[] product(int[] nums){
        int j = 0;
        int zeroCount = 0;
        int zeroIndex = -1;
        int arr[] = new int[nums.length];

        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
                zeroIndex = i;
                if (zeroCount > 1) {
                    break;
                }
            } else {
                product *= nums[i];
            }
        }

        if (zeroCount > 1) {
            return arr;
        } else if (zeroCount == 1) {
            arr[zeroIndex] = product;
            return arr;
        } else {
            for (int k = 0; k < arr.length; k++) {
                arr[k] = product / nums[k];
            }
        }


        return arr;
    }

}
