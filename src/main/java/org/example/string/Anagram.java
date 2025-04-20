package org.example.string;

import java.util.Arrays;
import java.util.HashMap;

public class Anagram {
    public static void main(String[] args) {

//        String str1 = "geeks";
//        String str2 = "eegkk";
//        isAnagram(str1, str2);
//        isAnagramHashMap(str1, str2);
    }

    public static void isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) System.out.println("Not Anagram");

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        if (Arrays.equals(arr1, arr2)) {
            System.out.println("Anagram");
        } else {
            System.out.println("Not Anagram");
        }
    }

    public static void isAnagramHashMap(String str1, String str2) {
        if (str1.length() != str2.length()) System.out.println("Not Anagram");

        HashMap<Character, Integer> charMap = new HashMap<>();

        char[] arr1 = str1.toCharArray();
        for (char c : arr1) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        char[] arr2 = str2.toCharArray();
        for (char c : arr2) {
            if (!charMap.containsKey(c) || charMap.get(c) == 0) {
                System.out.println("Not Anagram");
                return;
            }
            charMap.put(c, charMap.getOrDefault(c, 0) - 1);
        }

        System.out.println("Anagram");
    }

    public static void isAnagramUsingFrequencyArray(String str1, String str2) {
        if (str1.length() != str2.length()) System.out.println("Not Anagram");
        int[] freqArr = new int[26];

        for (char c : str1.toCharArray()) {
            freqArr[c - 'a']++;
        }

        for (char c : str2.toCharArray()) {
            freqArr[c - 'a']--;
        }

        for (int freq : freqArr) {
            if (freq != 0) {
                System.out.println("Not Anagram");
                return;
            }
        }

        System.out.println("Anagram");
    }
}
