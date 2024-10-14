package org.example.solutions.leetcode1kto2k;

public class Solution1994 {
    class Solution {
        private static final int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        private static final int mod = (int) 1e9 + 7, mx = 30, n_primes = primes.length;

        public int numberOfGoodSubsets(int[] nums) {
            int n = nums.length;
            int[] cnts = new int[mx + 1];
            for (int i : nums) {
                cnts[i]++;
            }
            int mask = 1 << n_primes;
            long[] f = new long[mask];
            f[0] = 1;
            for (int i = 2; i <= 30; i++) {
                if (cnts[i] == 0) continue;
                int cur = 0, x = i;
                boolean flag = true;
                for (int j = 0; j < n_primes && flag; j++) {
                    int t = primes[j], c = 0;
                    while (x % t == 0) {
                        cur |= (1 << j);
                        x /= t;
                        c++;
                    }
                    if (c > 1) flag = false;
                }
                if (!flag) continue;
                for (int prev = mask - 1; prev >= 0; prev--) {
                    if ((prev & cur) != 0) continue;
                    f[prev | cur] = (f[prev | cur] + f[prev] * cnts[i]) % mod;
                }
            }
            long ans = 0;
            for (int i = 1; i < mask; i++) {
                ans = (ans + f[i]) % mod;
            }
            for (int i = 0; i < cnts[1]; i++) {
                ans = ans * 2 % mod;
            }
            return (int) ans;
        }
    }
}