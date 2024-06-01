package org.example.solutions.leetcode3k;

public class Solution3163 {
    class Solution {
        public String compressedString(String word) {
            int n = word.length();
            StringBuilder compressed = new StringBuilder();
            for (int i = 0; i < n; ) {
                int j = 1;
                while (j < 9 && i + j < n && word.charAt(i + j) == word.charAt(i)) {
                    j++;
                }
                compressed.append(j).append(word.charAt(i));
                i += j;
            }
            return compressed.toString();
        }
    }
}