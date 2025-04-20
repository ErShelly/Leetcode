package org.example.greedy;

public class JumpGame {
    public static void main(String[] args){
        int[] arr = new int[] {1,1,2,5,2,1,0,0,1,3};
        System.out.println(canJump(arr));

        System.out.println(canJump(new int[]{3,2,1,0,4}));

    }


    //Time complexity = O(n)
    // Space Complexity = O(1)
    private static boolean canJump(int[] arr){
        int n = arr.length;
        int finalPos = n - 1;

        for(int i=n-2; i>=0;i--){
            if(i + arr[i] >= finalPos){
                finalPos = i;
            }
        }
        return finalPos == 0;
    }
}
