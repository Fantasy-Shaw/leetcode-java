package org.example.solutions.leetcode501to1k;

public class Solution878 {
    class Solution {
        public int nthMagicalNumber(int n, int a, int b) {
            long l = 0, r = (long) Math.min(a, b) * n + 1;
            long _lcm = lcm(a, b);
            while (l < r) {
                long mid = l + (r - l) / 2;
                if (mid / a + mid / b - mid / _lcm < n) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return (int) (l % 1_000_000_007);
        }

        private static long gcd(long a, long b) {
            if (b == 0) return a;
            return gcd(b, a % b);
        }

        private static long lcm(long a, long b) {
            return a * b / gcd(a, b);
        }
    }
}