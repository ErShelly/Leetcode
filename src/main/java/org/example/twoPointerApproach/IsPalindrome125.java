package org.example.twoPointerApproach;

public class IsPalindrome125 {
    public static void main(String[] args){
        IsPalindrome125 palindrome = new IsPalindrome125();
        System.out.println(palindrome.isPalindrome("A man, a plan, a canal: Panama"));
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left<right){
            //while(left < right && !Character.isLetterOrDigit(s.charAt(left))){
            while(left < right && !isAlphaNumeric(s.charAt(left))){
                left++;
            }

            //while(left < right && !Character.isLetterOrDigit(s.charAt(right))){
            while(left < right && !isAlphaNumeric(s.charAt(right))){
                right--;
            }

            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }

            left++;
            right--;
        }
        return true;
    }

    private boolean isAlphaNumeric(Character c){
        return (c >= 'a' && c<='z' || c >= 'A' && c <= 'Z' || c >= '0' && c<='9');
    }


}
