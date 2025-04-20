package org.example.slidingWindow;


import java.util.HashMap;

//Leetcode 424
public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args){
        System.out.println(characterReplacement("ABAB", 2)); //4
        System.out.println(characterReplacement("AABABBA", 1)); //4
    }

    //Time Complexity: O(n)
    //Space Complexity: O(m)

    //Where n is the length of the string and
    //m is the total number of unique characters in the string.
    public static int characterReplacement(String s, int k) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        int l=0;

        int maxLen =0;
        int maxF = 0;
        for(int r=0; r<s.length(); r++){
            char c = s.charAt(r);
            charMap.put(c, charMap.getOrDefault(c, 0)+1);
            maxF = Math.max(maxF, charMap.get(c));


            while((r-l)+1 - maxF > k){
                charMap.put(s.charAt(l), charMap.get(s.charAt(l))-1);
                l++;
            }

            maxLen = Math.max(maxLen, (r-l)+1);
        }
        return maxLen;
    }
}
