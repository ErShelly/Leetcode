package org.example;

import java.util.*;

public class AnagramGrouping {

    public static void main(String[] args) {
        String words = "eat tea tan ate nat bat";
        System.out.println(Arrays.toString(findLargestAnagramGroup(words)));
    }

    /**
     * Groups words into sets of anagrams and returns the group with the highest number of anagram words.
     *
     * @param input A string containing words separated by whitespace.
     * @return An array of strings representing the largest anagram group.
     */
    public static String[] findLargestAnagramGroup(String input) {
        if (input == null || input.trim().isEmpty()) {
            return new String[]{}; // Return empty array for null or empty input
        }

        String[] words = input.split("\\s+");
        Map<String, List<String>> anagramGroups = new HashMap<>();

        // Group words by their sorted character representation
        for (String word : words) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);

            anagramGroups.computeIfAbsent(sortedWord, k -> new ArrayList<>()).add(word);
        }

        // Find the largest group of anagrams
        List<String> largestGroup = new ArrayList<>();
        int maxGroupSize = 0;
        int earliestIndex = Integer.MAX_VALUE;

        for (List<String> group : anagramGroups.values()) {
            if (group.size() > maxGroupSize || (group.size() == maxGroupSize && indexOfFirstOccurrence(group, words) < earliestIndex)) {
                largestGroup = group;
                maxGroupSize = group.size();
                earliestIndex = indexOfFirstOccurrence(group, words);
            }
        }

        return largestGroup.toArray(new String[0]);
    }

    /**
     * Finds the earliest index of any word from the group in the original words array.
     *
     * @param group A list of words in the group.
     * @param words The original array of words.
     * @return The index of the first occurrence.
     */
    private static int indexOfFirstOccurrence(List<String> group, String[] words) {
        int earliestIndex = Integer.MAX_VALUE;
        for (String word : group) {
            for (int i = 0; i < words.length; i++) {
                if (word.equals(words[i])) {
                    earliestIndex = Math.min(earliestIndex, i);
                    break;
                }
            }
        }
        return earliestIndex;
    }
}

