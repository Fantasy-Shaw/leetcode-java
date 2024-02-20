package org.example.solutions.leetcode501to1k;

import java.util.*;

public class Solution526 {
    class Solution {
        public int countArrangement(int n) {
            int[][] memo = new int[n + 1][1 << n];
            for (var it : memo) {
                Arrays.fill(it, -1);
            }
            return dfs(n, memo, 1, 0);
        }

        private int dfs(int n, int[][] memo, int i, int vis) {
            if (i > n) return 1;
            if (memo[i][vis] != -1) {
                return memo[i][vis];
            }
            int ans = 0;
            for (int j = 1; j <= n; j++) {
                if (((vis >> (j - 1)) & 1) == 0 && (j % i == 0 || i % j == 0)) {
                    ans += dfs(n, memo, i + 1, (1 << (j - 1)) | vis);
                }
            }
            memo[i][vis] = ans;
            return ans;
        }
    }
}