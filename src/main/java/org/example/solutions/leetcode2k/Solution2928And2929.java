package org.example.solutions.leetcode2k;

public class Solution2928And2929 {
    class Solution {
        public long distributeCandies(int n, int limit) {
            // 隔板法 排列组合
            long all = c_n_2(n + 2);
            // at least 1x child's n_candy > limit
            long t1 = c_n_2(n - (limit + 1) + 2) * 3;
            // at least 2x children's n_candy > limit
            long t2 = c_n_2(n - (limit + 1) * 2 + 2) * 3;
            // at least 3x children's n_candy > limit
            long t3 = c_n_2(n - (limit + 1) * 3 + 2);
            return all - t1 + t2 - t3;

        }

        private static long c_n_2(int n) {
            return n > 1 ? (long) n * (n - 1) / 2 : 0;
        }
    }
}