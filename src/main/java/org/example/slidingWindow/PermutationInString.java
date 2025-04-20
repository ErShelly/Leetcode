package org.example.slidingWindow;

//Leetcode 567
public class PermutationInString {
    public static void main(String[] args){
        PermutationInString permutationInString = new PermutationInString();
        System.out.println(permutationInString.checkInclusion("ab", "eidbaooo")); //true
        System.out.println(permutationInString.checkInclusion("ab", "eidboaooo")); //false
    }
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() == 0 || s1.length() > s2.length()) return false;

        int[] s1Map = new int[26];
        int[] s2Map = new int[26];

        for(int i=0; i<s1.length(); i++){
            s1Map[s1.charAt(i) - 'a']++;
            s2Map[s2.charAt(i) - 'a']++;
        }

        for(int i=0; i<= s2.length() - s1.length(); i++){
            if(matches(s1Map, s2Map)) return true;

            if(i + s1.length() < s2.length()){
                s2Map[s2.charAt(i) - 'a']--;
                s2Map[s2.charAt(i + s1.length()) - 'a']++;
            }
        }
        return false;
    }

    private boolean matches(int[] a, int[] b){
        for(int i=0; i<a.length; i++){
            if(a[i] != b[i]) return false;
        }
        return true;
    }
}
