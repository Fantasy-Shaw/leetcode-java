package org.example.solutions.leetcode1kto2k;

public class Solution1969 {
    class Solution {
        static final int mod = (int) 1e9 + 7;

        public int minNonZeroProduct(int p) {
            long a = 1L << p;
            long b = 1L << (p - 1);
            return (int) (((a - 1) % mod) * pow(a - 2, b - 1) % mod);
        }

        static long pow(long x, long n) {
            x %= mod;
            long ans = 1;
            for (; n > 0; n /= 2) {
                if (n % 2 == 1) {
                    ans = ans * x % mod;
                }
                x = x * x % mod;
            }
            return ans % mod;
        }
    }
}