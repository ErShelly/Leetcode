package org.example.twoPointerApproach;

public class LongestSubstringWithoutRepeatedCharacters {
    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("abcabcbb"));

    }


    //NotEfficient - O(n)
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() < 2) return s.length();
        int longest = 1;
        StringBuilder str = new StringBuilder();
        str.append(s.charAt(0));
        for(int right=1; right<s.length(); right++){
            while(str.indexOf(String.valueOf(s.charAt(right)))!=-1){
                str.deleteCharAt(0);
            }
            str.append(s.charAt(right));

            longest = Math.max(longest, str.length());

        }
        return longest;
    }
}
