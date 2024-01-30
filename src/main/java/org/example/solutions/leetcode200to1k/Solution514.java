package org.example.solutions.leetcode200to1k;

import java.util.*;

public class Solution514 {
    class Solution {
        int[][] memo, left, right;
        char[] rcs, kcs;
        int n, m;

        public int findRotateSteps(String ring, String key) {
            rcs = ring.toCharArray();
            kcs = key.toCharArray();
            n = ring.length();
            m = key.length();
            int[] pos = new int[26];
            Arrays.fill(pos, -1);
            for (int i = 0; i < n; i++) {
                pos[rcs[i] - 'a'] = i;
            }
            left = new int[n][26];
            for (int i = 0; i < n; i++) {
                left[i] = pos.clone();
                pos[rcs[i] - 'a'] = i;
            }
            for (int i = n - 1; i >= 0; i--) {
                pos[rcs[i] - 'a'] = i;
            }
            right = new int[n][26];
            for (int i = n - 1; i >= 0; i--) {
                right[i] = pos.clone();
                pos[rcs[i] - 'a'] = i;
            }
            memo = new int[m][n];
            for (var it : memo) {
                Arrays.fill(it, -1);
            }
            return dfs(0, 0) + m;
        }

        private int dfs(int i, int j) {
            if (i == m) {
                return 0;
            }
            if (memo[i][j] != -1) {
                return memo[i][j];
            }
            int u = kcs[i] - 'a', v = rcs[j] - 'a';
            if (u == v) {
                int ans = dfs(i + 1, j);
                memo[i][j] = ans;
                return ans;
            }
            int l = left[j][u], r = right[j][u];
            int ans = Math.min(
                    dfs(i + 1, l) + (l > j ? n - l + j : j - l),
                    dfs(i + 1, r) + (r < j ? n - j + r : r - j)
            );
            memo[i][j] = ans;
            return ans;
        }
    }
}