package org.example.solutions.leetcode2k;

import java.util.*;

import org.example.templates.RolliingHash.DoubleStringHash;

public class Solution2851 {
    class Solution {
        static final int mod = (int) 1e9 + 7;

        public int numberOfWays(String s, String t, long k) {
            int n = s.length();
            DoubleStringHash hashS = new DoubleStringHash(s + s);
            long[] hashT = new DoubleStringHash(t).getHash(0, n);
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (Arrays.equals(hashS.getHash(i, i + n), hashT)) {
                    cnt++;
                }
            }
            long[][] m = new long[][]{{cnt - 1, cnt}, {n - cnt, n - cnt - 1}};
            m = quick_pow(m, k);
            return s.equals(t) ? (int) m[0][0] : (int) m[0][1];
        }

        private static long[][] quick_pow(long[][] m, long k) {
            long[][] ans = {{1, 0}, {0, 1}}; // Identity Mat
            for (; k > 0; k /= 2) {
                if (k % 2 == 1) {
                    ans = mul(ans, m);
                }
                m = mul(m, m);
            }
            return ans;
        }

        private static long[][] mul(long[][] a, long[][] b) {
            long[][] ans = new long[2][2];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    ans[i][j] = (a[i][0] * b[0][j] + a[i][1] * b[1][j]) % mod;
                }
            }
            return ans;
        }
    }
}