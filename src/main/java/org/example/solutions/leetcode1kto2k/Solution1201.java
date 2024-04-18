package org.example.solutions.leetcode1kto2k;

public class Solution1201 {
    class Solution {
        long a, b, c;
        long _lcmAB, _lcmBC, _lcmAC, _lcmABC;

        public int nthUglyNumber(int n, int a, int b, int c) {
            init(a, b, c);
            long l = 0, r = (long) Math.min(a, Math.min(b, c)) * n + 1;
            while (l < r) {
                long mid = l + (r - l) / 2;
                if (count(mid) < n) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return (int) l;
        }

        private void init(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
            _lcmAB = lcm(a, b);
            _lcmAC = lcm(a, c);
            _lcmBC = lcm(b, c);
            _lcmABC = lcm(a, _lcmBC);
        }

        private long count(long mid) {
            return mid / a + mid / b + mid / c - mid / _lcmAB - mid / _lcmAC - mid / _lcmBC + mid / _lcmABC;
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