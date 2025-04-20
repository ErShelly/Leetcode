package org.example.string;

import sun.lwawt.macosx.CSystemTray;

public class permutation {

    public static void main(String[] args){
        String str = "abc";
        printPermutations(str, "");
    }

    public static void printPermutations(String str, String permutation){
        if(str.length() == 0){
            System.out.println(permutation);
            return;
        }

        for(int i=0; i<str.length();i++){
            char curr = str.charAt(i);
            String str1 = str.substring(0, i);
            String str2 =  str.substring(i+1);
            String newStr = str1 + str2;
            printPermutations(newStr, permutation+curr);
        }
    }
}
