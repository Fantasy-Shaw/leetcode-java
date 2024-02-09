package org.example.solutions.leetcode1to200;

public class Solution7 {
    class Solution {
        public int reverse(int x) {
            long sign = x >= 0 ? 1 : -1;
            long a = Math.abs((long) x);
            long ans = 0;
            while (a > 0) {
                ans = ans * 10 + a % 10;
                a /= 10;
            }
            ans *= sign;
            return (Integer.MIN_VALUE <= ans && ans <= Integer.MAX_VALUE) ? (int) ans : 0;
        }
    }
}