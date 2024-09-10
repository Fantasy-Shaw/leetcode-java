package org.example.solutions.leetcode3k;

public class Solution3247 {
    class Solution {
        private static final int mod = (int) 1e9 + 7;

        public int subsequenceCount(int[] nums) {
            int[] cnt = new int[2];
            for (var x : nums) {
                cnt[x & 1]++;
            }
            long ans = cnt[1] > 0 ? qpow(2, cnt[1] - 1) * qpow(2, cnt[0]) : 0;
            return (int) (ans % mod);
        }

        private long qpow(long x, long n) {
            long ans = 1 % mod;
            while (n > 0) {
                if ((n & 1) == 1) {
                    ans = ans * x % mod;
                }
                x = x * x % mod;
                n >>>= 1;
            }
            return ans;
        }
    }
}