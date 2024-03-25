package org.example.solutions.leetcode3k;

public class Solution3090 {
    class Solution {
        public int maximumLengthSubstring(String s) {
            int ans = 0;
            for (int i = 0; i < s.length(); i++) {
                for (int j = i + 1; j <= s.length(); j++) {
                    if (isValid(s.substring(i, j))) {
                        ans = Math.max(ans, j - i);
                    }
                }
            }
            return ans;
        }

        private boolean isValid(String s) {
            int[] map = new int[26];
            for (int i = 0; i < s.length(); i++) {
                if (++map[s.charAt(i) - 'a'] > 2) {
                    return false;
                }
            }
            return true;
        }
    }
}