package org.example.slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams {

    //Time Complexity: O(n+m) == O(n)
    //Space: O(1)
    public List<Integer> findAnagrams(String s, String p){
        List<Integer> anagrams = new ArrayList<>();
        if(s.length() < p.length()) return anagrams;

        int[] pfreq = new int[26];
        for(char c: p.toCharArray()){
            pfreq[c - 'a']++;
        }

        int windowSize = p.length();
        int[] sfreq = new int[26];

        for(int i=0;i<s.length(); i++){
            sfreq[s.charAt(i) - 'a']++;

            if(i>= windowSize) sfreq[s.charAt(i - windowSize) - 'a']--;

            if(Arrays.equals(sfreq, pfreq)) {
                anagrams.add(i-windowSize+1);
            }
        }
        return anagrams;



    }
    public static void main(String[] args){
        FindAnagrams fa = new FindAnagrams();
        System.out.println(fa.findAnagrams("cbaebabacd", "abc"));
    }
}
