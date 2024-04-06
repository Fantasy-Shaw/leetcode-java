package org.example.solutions.leetcode201to500;

import java.util.*;

public class Solution329 {
    class Solution {
        public int longestIncreasingPath(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            int[][] f = new int[m][n];
            for (var it : f) {
                Arrays.fill(it, -1);
            }
            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    ans = Math.max(dfs(matrix, i, j, f), ans);
                }
            }
            ans += 1;
            return ans;
        }

        private int dfs(int[][] matrix, int i, int j, int[][] f) {
            if (f[i][j] != -1) return f[i][j];
            int x1 = 0, x2 = 0, x3 = 0, x4 = 0;
            if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) {
                x1 = 1 + dfs(matrix, i - 1, j, f);
            }
            if (i + 1 < matrix.length && matrix[i + 1][j] > matrix[i][j]) {
                x2 = 1 + dfs(matrix, i + 1, j, f);
            }
            if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {
                x3 = 1 + dfs(matrix, i, j - 1, f);
            }
            if (j + 1 < matrix[0].length && matrix[i][j + 1] > matrix[i][j]) {
                x4 = 1 + dfs(matrix, i, j + 1, f);
            }
            f[i][j] = Math.max(Math.max(x1, x2), Math.max(x3, x4));
            return f[i][j];
        }
    }
}