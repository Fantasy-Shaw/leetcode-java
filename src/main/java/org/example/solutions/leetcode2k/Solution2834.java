package org.example.solutions.leetcode2k;

public class Solution2834 {
    class Solution {
        /**
         * Pairs:  (1,k-1),(2,k-2)... select 1 of 2 ==> minSum : sum(1,...,k//2 - 1)
         * k % 2 == 0 : select k/2, k % 2 == 1, select k/2 or k/2+1 ==> select k//2
         * ==> Part 1 : sum(1,...,k//2)
         * int m = k//2
         * curLen == m
         * expect extra len of n - m
         * select all of [k, n - m + k - 1]
         * sum : n*a1 + n*(n-1)*d/2
         */
        static final int mod = (int) (1e9 + 7);

        public int minimumPossibleSum(int n, int k) {
            long m = Math.min(k / 2, n);
            long ans = m * (m + 1) / 2;
            ans %= mod;
            ans += ((n - m) * k + (n - m) * (n - m - 1) / 2) % mod;
            ans %= mod;
            return (int) ans;
        }
    }
}