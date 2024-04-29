package org.example.solutions.leetcode3k;

public class Solution3128 {
    class Solution {
        public long numberOfRightTriangles(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[][] sumM = new int[n][m + 1], sumN = new int[m][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sumN[i][j + 1] = sumN[i][j] + grid[i][j];
                }
            }
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < m; i++) {
                    sumM[j][i + 1] = sumM[j][i] + grid[i][j];
                }
            }
            long ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        ans += (long) (sumN[i][j] - sumN[i][0]) * (sumM[j][i] - sumM[j][0]);
                        ans += (long) (sumN[i][j] - sumN[i][0]) * (sumM[j][m] - sumM[j][i + 1]);
                        ans += (long) (sumN[i][n] - sumN[i][j + 1]) * (sumM[j][m] - sumM[j][i + 1]);
                        ans += (long) (sumN[i][n] - sumN[i][j + 1]) * (sumM[j][i] - sumM[j][0]);
                    }
                }
            }
            return ans;
        }
    }
}