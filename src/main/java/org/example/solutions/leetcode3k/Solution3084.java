package org.example.solutions.leetcode3k;

public class Solution3084 {
    class Solution {
        public long countSubstrings(String s, char c) {
            long freq = 0;
            for (char ch : s.toCharArray()) {
                if (ch == c) {
                    freq++;
                }
            }
            return freq * (freq + 1) / 2;
        }
    }
}