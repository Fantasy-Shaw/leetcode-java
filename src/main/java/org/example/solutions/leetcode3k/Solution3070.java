package org.example.solutions.leetcode3k;

public class Solution3070 {
    class Solution {
        public int countSubmatrices(int[][] grid, int k) {
            int m = grid.length, n = grid[0].length;
            int[][] sum = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + grid[i][j];
                }
            }
            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (getSum(sum, 0, 0, i, j) <= k) {
                        ans++;
                    }
                }
            }
            return ans;
        }

        public int getSum(int[][] sum, int x1, int y1, int x2, int y2) {
            return sum[x2 + 1][y2 + 1] - sum[x2 + 1][y1] - sum[x1][y2 + 1] + sum[x1][y1];
        }
    }
}