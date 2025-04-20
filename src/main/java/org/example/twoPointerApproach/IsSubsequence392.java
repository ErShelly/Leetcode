package org.example.twoPointerApproach;

public class IsSubsequence392 {
    public static void main(String[] args){
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("axc", "ahbgdc"));
    }
    public static boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();

        int i=0, j=0;
        while(i<n && j <m){
            if(s.charAt(i)==t.charAt(j)){
                i++;
            }

            j++;
        }
        return i == n;
    }
}
