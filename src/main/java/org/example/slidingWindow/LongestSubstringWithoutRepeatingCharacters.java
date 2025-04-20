package org.example.slidingWindow;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abba";
        System.out.println(lengthOfLongestSubstringOptimal(s));
    }

    //Time Complexity: O(n)
    //Space Complexity: O(k) k≤n (the length of the input string).
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left =0;
        int max=0;

        for(int right=0; right<s.length(); right++){
            char curr = s.charAt(right);
            while(set.contains(curr)){
                set.remove(s.charAt(left));
                left++;
            }

            set.add(curr);
            max = Math.max(max, right-left+1);
        }
        return max;
    }

    //Time complexity: O(n)
    //Space complexity:O(m) Where

    //n is the length of the string and
    //m is the total number of unique characters in the string.
    public static int lengthOfLongestSubstringOptimal(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        int max=0;
        int left=0;
        for(int right=0; right<s.length(); right++){
            char c = s.charAt(right);
            if(map.containsKey(c)){
                left = Math.max(left, map.get(c) + 1); // to ensure it only moves fwd incase multiple duplicates
            }
            map.put(c, right);
            max = Math.max(max, right-left+1);
        }
        return max;
    }
}
