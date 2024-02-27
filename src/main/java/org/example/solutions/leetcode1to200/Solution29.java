package org.example.solutions.leetcode1to200;

public class Solution29 {
    class Solution {
        static int lim = Integer.MIN_VALUE >> 1;

        public int divide(int dividend, int divisor) {
            if (dividend == Integer.MIN_VALUE && divisor == -1) {
                return Integer.MAX_VALUE;
            }
            int sign = ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) ? 1 : -1;
            int a = -Math.abs(dividend), b = -Math.abs(divisor);
            int ans = 0;
            while (a <= b) {
                int c = b, d = -1;
                while (c >= lim && d >= lim && c >= a - c) {
                    c += c;
                    d += d;
                }
                a -= c;
                ans += d;
            }
            return sign == 1 ? Math.abs(ans) : -Math.abs(ans);
        }
    }
}