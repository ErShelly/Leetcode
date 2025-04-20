package org.example.greedy;

public class JumpGame2 {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,1,4};
        System.out.println(jump(arr)); //2
    }


    //Time complexity = O(n)
    // Space Complexity = O(1)
    public static int jump(int[] nums) {
        int minJumps = 0;
        int l=0, r=0;

        while(r<nums.length-1){
            int farthest = 0;
            for(int i=l; i<=r; i++){
                farthest = Math.max(farthest, i + nums[i]);
            }

            l=r+1;
            r=farthest;
            minJumps++;
        }
        return minJumps;
    }
}
