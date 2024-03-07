package org.example.solutions.leetcode2k;

public class Solution2575 {
    class Solution {
        public int[] divisibilityArray(String word, int m) {
            int n = word.length();
            int[] ans = new int[n];
            long num = 0;
            for (int i = 0; i < n; i++) {
                num = num * 10 + (word.charAt(i) - '0');
                ans[i] = num % m == 0 ? 1 : 0;
                num %= m;
            }
            return ans;
        }
    }
}