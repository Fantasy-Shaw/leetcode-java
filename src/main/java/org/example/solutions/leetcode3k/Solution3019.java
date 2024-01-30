package org.example.solutions.leetcode3k;

public class Solution3019 {
    class Solution {
        public int countKeyChanges(String s) {
            int n = s.length();
            int ans = 0;
            for (int i = 1; i < n; i++) {
                char ch = s.charAt(i);
                char pre = s.charAt(i - 1);
                if (ch != lower(pre) && ch != upper(pre)) {
                    ans++;
                }
            }
            return ans;
        }

        private static char upper(char ch) {
            if ('A' <= ch && ch <= 'Z') return ch;
            return (char) ('A' + ch - 'a');
        }

        private static char lower(char ch) {
            if ('a' <= ch && ch <= 'z') return ch;
            return (char) ('a' + ch - 'A');
        }
    }
}