package org.example.solutions.leetcode200to1k;

public class Solution304 {
    private class NumMatrix {

        int[][] cache;

        public NumMatrix(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            cache = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    cache[i + 1][j + 1] = cache[i][j + 1] + cache[i + 1][j] - cache[i][j] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return cache[row2 + 1][col2 + 1] - cache[row1][col2 + 1] - cache[row2 + 1][col1] + cache[row1][col1];
        }
    }
}

