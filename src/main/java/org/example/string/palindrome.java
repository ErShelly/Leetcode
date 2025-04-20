package org.example.string;

public class palindrome {
    public static void main(String[] args){
        String str = "abbcbba";
//        isPalindrome(str);
        isPalindrome(str, 0, str.length()-1);

    }

    public static void isPalindrome(String str){
        char[] arr = str.toCharArray();
        int n=arr.length;
        int j = n-1;
        for(int i=0; i<=n/2; i++){
            if(arr[i]!=arr[j]) {
                System.out.println("Not palindrome");
                return;
            }
            j--;
        }
        System.out.println("Palindrome");
    }

    public static void isPalindrome(String str, int left, int right){
        if(left>=right){
            System.out.println("Palindrome");
            return;
        }

        if(str.charAt(left) != str.charAt(right)){
            System.out.println("Not palindrome");
            return;
        }
        isPalindrome(str, left+1, right-1);
    }
}
