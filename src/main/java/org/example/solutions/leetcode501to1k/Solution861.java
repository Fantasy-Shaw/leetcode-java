package org.example.solutions.leetcode501to1k;

public class Solution861 {
    class Solution {
        public int matrixScore(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int ans = m * (1 << (n - 1));
            for (int j = 1; j < n; j++) {
                int x = 0;
                for (int i = 0; i < m; i++) {
                    if (grid[i][0] == 1) {
                        x += grid[i][j];
                    } else {
                        x += (1 - grid[i][j]);
                    }
                }
                int k = Math.max(x, m - x);
                ans += k * (1 << (n - j - 1));
            }
            return ans;
        }
    }
}