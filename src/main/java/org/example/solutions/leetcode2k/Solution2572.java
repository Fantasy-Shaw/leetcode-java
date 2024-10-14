package org.example.solutions.leetcode2k;

public class Solution2572 {
    class Solution {
        private static final int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        private static final int mod = (int) 1e9 + 7, mx = 30, n_primes = primes.length, m = 1 << n_primes;
        private static final int[] sf_to_mask = new int[mx + 1]; // i的质因子集合

        static {
            for (int i = 2; i <= mx; i++) {
                for (int j = 0; j < n_primes; j++) {
                    int p = primes[j];
                    if (i % p == 0) {
                        if (i % (p * p) == 0) {
                            sf_to_mask[i] = -1;
                            break;
                        }
                        sf_to_mask[i] |= 1 << j;
                    }
                }
            }
        }

        public int squareFreeSubsets(int[] nums) {
            int[] cnt = new int[mx + 1];
            int pow2 = 1;
            for (int x : nums) {
                if (x == 1) pow2 = pow2 * 2 % mod;
                else cnt[x]++;
            }
            long[] f = new long[m];
            f[0] = pow2;
            for (int x = 2; x <= mx; x++) {
                int mask = sf_to_mask[x], c = cnt[x];
                if (mask > 0 && c > 0) {
//                    int cm = (m - 1) ^ mask, j = cm;
//                    do {
//                        f[j | mask] = (f[j | mask] + f[j] * cnt[x]) % mod;
//                        j = (j - 1) & cm;
//                    } while (j != cm);
                    int cm = (m - 1) ^ mask;
                    for (int j = cm; j > 0; j = (j - 1) & cm) {
                        f[j | mask] = (f[j | mask] + f[j] * cnt[x]) % mod;
                    }
                    f[mask] = (f[mask] + f[0] * cnt[x]) % mod;
                }
            }
            long ans = 0;
            for (long v : f) {
                ans += v;
                ans %= mod;
            }
            return (int) (ans + mod - 1) % mod;
        }

        public int squareFreeSubsets111(int[] nums) {
            int[] f = new int[m];
            f[0] = 1;
            for (int x : nums) {
                int mask = sf_to_mask[x];
                if (mask >= 0) {
                    for (int j = m - 1; j >= mask; j--) {
                        if ((j | mask) == j) {
                            f[j] = (f[j] + f[j ^ mask]) % mod;
                        }
                    }
                }
            }
            int ans = 0;
            for (int v : f) {
                ans += v;
                ans %= mod;
            }
            return ((ans + mod) - 1) % mod;
        }
    }
}