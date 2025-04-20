package org.example.hashmap;

import java.util.*;
import java.util.HashMap;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams2(strs));
    }

    //O(n⋅klogk).
    public static List<List<String>> groupAnagrams(String[] strs) {
        java.util.HashMap<String, List<String>> map = new java.util.HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);

            String sortedKey = new String(charArray);
            map.putIfAbsent(sortedKey, new ArrayList<>());
            map.get(sortedKey).add(str);
        }

        return new ArrayList<>(map.values());
    }

    //Not efficient as Array.toString will take more time
    public static List<List<String>> groupAnagrams2(String[] strs) {
        java.util.HashMap<String, List<String>> map = new java.util.HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            char[] charArray = str.toCharArray();
            for(char c: charArray){
                count[c - 'a']++;
            }

            String key = Arrays.toString(count);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }

    //efficient O(n*m)
    public List<List<String>> groupAnagrams3(String[] strs) {
        java.util.HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] count = new char[26];
            for(char c: str.toCharArray()){
                count[c - 'a']++;
            }

            String key = new String(count);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());


    }
}
