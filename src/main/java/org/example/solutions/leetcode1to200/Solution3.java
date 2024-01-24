package org.example.solutions.leetcode1to200;

public class Solution3 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            boolean[] charSet = new boolean[128];
            int charSetSize = 0;
            int n = s.length();
            int rk = -1, ans = 0;
            for (int i = 0; i < n; i++) {
                if (i != 0) {
                    charSet[s.charAt(i - 1)] = false;
                    charSetSize--;
                }
                while (rk < n - 1 && !charSet[s.charAt(rk + 1)]) {
                    charSet[s.charAt(rk + 1)] = true;
                    charSetSize++;
                    rk++;
                }
                ans = Math.max(ans, rk - i + 1);
            }
            return ans;
        }
    }
}