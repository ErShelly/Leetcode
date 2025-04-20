package org.example.string;

import java.util.Arrays;

public class PalindromeSubstring {
    public static void main(String[] args) {
        String str = "abaab";

        palindromicSubstring(str);
    }

    public static void palindromicSubstring(String str) {
        int count = 0;
        for(int i=0; i<str.length(); i++){
            for(int j=i+1; j<str.length(); j++){
                if(isPalindrome(str, i, j)){
                    count++;
                }
            }
        }
        System.out.println("Count: "+ count);
    }

    public static boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)){
               return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
