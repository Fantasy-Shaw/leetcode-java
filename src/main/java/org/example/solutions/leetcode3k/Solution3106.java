package org.example.solutions.leetcode3k;

public class Solution3106 {
    class Solution {
        public String getSmallestString(String s, int k) {
            StringBuilder ans = new StringBuilder();
            for (char c : s.toCharArray()) {
                int d = dist2a(c);
                if (d <= k) {
                    k -= d;
                    ans.append('a');
                } else {
                    ans.append(minAdd(c, k));
                    k = 0;
                }
            }
            return ans.toString();
        }

        private int dist2a(char ch) {
            int x = ch - 'a';
            return Math.min(x, 26 - x);
        }

        private char minAdd(char ch, int d) {
            int x = ch - 'a';
            int ans = Math.min((x + d) % 26, (x - d + 26) % 26);
            return (char) ('a' + ans);
        }
    }
}