package org.example.solutions.leetcode501to1k;

public class Solution809 {
    class Solution {
        public int expressiveWords(String s, String[] words) {
            int ans = 0;
            for (var t : words) {
                if (isExpressive(s, t)) {
                    ans++;
                }
            }
            return ans;
        }

        private boolean isExpressive(String s, String t) {
            if (s.length() < t.length()) {
                return false;
            }
            int i = 0, j = 0, x = 0, y = 0;
            while (i < s.length() && x < t.length()) {
                if (s.charAt(i) != t.charAt(x)) {
                    return false;
                }
                while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                    j++;
                }
                while (y < t.length() && t.charAt(y) == t.charAt(x)) {
                    y++;
                }
                int m = j - i, n = y - x;
                if (!(m == n || (m > n && m >= 3))) {
                    return false;
                }
                i = j;
                x = y;
            }
            return i == s.length() && x == t.length();
        }
    }
}