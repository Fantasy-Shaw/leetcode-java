package org.example.solutions.leetcode501to1k;

import java.util.*;

public class Solution524 {
    class Solution {
        public String findLongestWord(String s, List<String> dictionary) {
            dictionary.sort((a, b) -> a.length() == b.length() ? a.compareTo(b) : b.length() - a.length());
            for (var word : dictionary) {
                int i = 0, j = 0;
                while (i < s.length() && j < word.length()) {
                    if (s.charAt(i) == word.charAt(j)) {
                        i++;
                        j++;
                    } else {
                        i++;
                    }
                }
                if (j == word.length()) {
                    return word;
                }
            }
            return "";
        }
    }
}