package org.example.solutions.leetcode2k;

public class Solution2744 {
    class Solution {
        public int maximumNumberOfStringPairs(String[] words) {
            int ans = 0;
            boolean[] vis = new boolean[words.length];
            for (int i = 0; i < words.length; i++) {
                if (vis[i]) continue;
                for (int j = i + 1; j < words.length; j++) {
                    if (vis[j]) continue;
                    if (isRevEqual(words[i], words[j])) {
                        vis[i] = vis[j] = true;
                        ans++;
                    }
                }
            }
            return ans;
        }

        private static boolean isRevEqual(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(s1.length() - i - 1)) {
                    return false;
                }
            }
            return true;
        }
    }
}