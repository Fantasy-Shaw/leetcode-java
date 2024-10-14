package org.example.solutions.leetcode1to200;

import java.util.Arrays;

public class Solution62 {
    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] f = new int[m][n];
            for (var it : f) {
                Arrays.fill(it, -1);
            }
            f[0][0] = 1;
            dfs(m - 1, n - 1, f);
            return f[m - 1][n - 1];
        }

        private int dfs(int i, int j, int[][] f) {
            if (i < 0 || i >= f.length || j < 0 || j >= f[0].length) {
                return 0;
            }
            if (f[i][j] != -1) {
                return f[i][j];
            }
            f[i][j] = dfs(i - 1, j, f) + dfs(i, j - 1, f);
            return f[i][j];
        }
    }
}