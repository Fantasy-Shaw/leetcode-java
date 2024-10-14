package org.example.solutions.leetcode1kto2k;

import java.util.Arrays;

public class Solution1494 {
    class Solution {
        public int minNumberOfSemesters(int n, int[][] relations, int k) {
            int[] pre = new int[n];
            for (int[] r : relations) {
                pre[r[1] - 1] |= 1 << (r[0] - 1);
            }
            int u = (1 << n) - 1;
            int[] f = new int[u + 1];
            f[0] = 0;
            for (int i = 1; i <= u; i++) {
                int i1 = 0, ci = u ^ i;
                for (int j = 0; j < n; j++) {
                    if (((i >> j) & 1) > 0 && (pre[j] | ci) == ci) {
                        i1 |= 1 << j;
                    }
                }
                if (Integer.bitCount(i1) <= k) {
                    f[i] = f[i ^ i1] + 1;
                    continue;
                }
                f[i] = Integer.MAX_VALUE;
                for (int j = i1; j > 0; j = (j - 1) & i1) {
                    if (Integer.bitCount(j) == k) {
                        f[i] = Math.min(f[i], f[i ^ j] + 1);
                    }
                }
            }
            return f[u];
        }
    }

    class Solution1 {
        private int[] pre, memo;
        private int k, u;

        public int minNumberOfSemesters(int n, int[][] relations, int k) {
            this.k = k;
            this.u = (1 << n) - 1;
            pre = new int[n];
            memo = new int[1 << n];
            Arrays.fill(memo, -1);
            for (int[] r : relations) {
                pre[r[1] - 1] |= 1 << (r[0] - 1);
            }
            return dfs(u);
        }

        private int dfs(int i) {
            if (memo[i] != -1) return memo[i];
            if (i == 0) return 0;
            int i1 = 0, ci = u ^ i;
            for (int j = 0; j < pre.length; j++) {
                if (((i >> j) & 1) > 0 && (pre[j] | ci) == ci) {
                    i1 |= 1 << j;
                }
            }
            if (Integer.bitCount(i1) <= k) {
                return memo[i] = dfs(i ^ i1) + 1;
            }
            int res = Integer.MAX_VALUE;
            for (int j = i1; j > 0; j = (j - 1) & i1) {
                if (Integer.bitCount(j) == k) {
                    res = Math.min(res, dfs(i ^ j) + 1);
                }
            }
            return memo[i] = res;
        }
    }
}