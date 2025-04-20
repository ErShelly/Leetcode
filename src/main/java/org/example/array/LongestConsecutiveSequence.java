package org.example.array;

import java.util.HashMap;
import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        longestConsecutive(nums);
        longestConsecutive2(nums);
        longestConsecutive3(nums);
    }

    //Time Complexity: O(n^2)
    //Space Complexity: O(n)
    private static void longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }

        int max=0;
        for(int n:nums){
            int streak = 0;
            int curr = n;
            while(set.contains(curr)){
                streak++;
                curr++;
            }
            max = Math.max(max,streak);
        }
        System.out.println(max);
    }

    //O(n)
    private static void longestConsecutive2(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }

        int max=0;
        for(int n:set){
            if(!set.contains(n-1)){
                int len=1;
                while (set.contains(n+len)){
                    len++;
                }
                max = Math.max(max, len);
                if(max>nums.length/2) break;
            }
        }
        System.out.println(max);
    }

    //O(n)
    private static void longestConsecutive3(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();

        int longest = 0;
        for(int num:nums){
            if(!map.containsKey(num)){
                int left = map.getOrDefault(num-1,0);
                int right = map.getOrDefault(num+1, 0);
                int len = left+right+1;

                map.put(num, len);
                map.put(num-left,len);
                map.put(num+right,len);

                longest = Math.max(longest, len);
            }
        }
        System.out.println(longest);
    }
}
