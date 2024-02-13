package org.example.solutions.leetcode201to500;

public class Solution214 {
    class Solution {
        private final int base = 1313131;
        private long[] prime;

        public String shortestPalindrome(String s) {
            if (s.isEmpty()) return s;
            int n = s.length();
            prime = new long[n + 1];
            prime[0] = 1;
            char[] cs = s.toCharArray();
            long l = 0, r = 0;
            int best = -1;
            for (int i = 0; i < n; i++) {
                l = l * base + cs[i];
                r = r + prime[i] * cs[i];
                if (l == r) {
                    best = i;
                }
                prime[i + 1] = prime[i] * base;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(best == n - 1 ? "" : s.substring(best + 1, n));
            sb.reverse().append(s);
            return sb.toString();
        }
    }
}