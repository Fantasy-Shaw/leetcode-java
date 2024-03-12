package org.example.solutions.leetcode2k;

public class Solution2829 {
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
        public int minimumSum(int n, int k) {
            int m = Math.min(k / 2, n);
            int ans = m * (m + 1) / 2;
            ans += (n - m) * k + (n - m) * (n - m - 1) / 2;
            return ans;
        }
    }
}