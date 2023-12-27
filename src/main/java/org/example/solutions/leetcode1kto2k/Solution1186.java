package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1186 {
    class Solution {
        private static final int inf = 0x3f3f3f3f;
        private int[] arr;
        private int[][] memo;

        public int maximumSum(int[] arr) {
            this.arr = arr;
            int ans = -inf, n = arr.length;
            memo = new int[n][2];
            for (int i = 0; i < n; i++) {
                Arrays.fill(memo[i], -inf);
            }
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, Math.max(dfs(i, 0), dfs(i, 1)));
            }
            return ans;
        }

        private int dfs(int i, int j) {
            if (i < 0) return -inf;
            if (memo[i][j] != -inf) {
                return memo[i][j];
            }
            if (j == 0) {
                return memo[i][j] = Math.max(dfs(i - 1, 0), 0) + arr[i];
            }
            return memo[i][j] = Math.max(dfs(i - 1, 1) + arr[i], dfs(i - 1, 0));
        }
    }
}