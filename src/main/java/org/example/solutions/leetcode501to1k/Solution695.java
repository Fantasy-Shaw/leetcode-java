package org.example.solutions.leetcode501to1k;

public class Solution695 {
    class Solution {
        private int m, n;
        private int[][] grid;
        private boolean[][] vis;
        private int curArea;

        public int maxAreaOfIsland(int[][] grid) {
            m = grid.length;
            n = grid[0].length;
            this.grid = grid;
            vis = new boolean[m][n];
            int maxArea = 0;
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    curArea = 0;
                    dfs(row, col);
                    maxArea = Math.max(curArea, maxArea);
                }
            }
            return maxArea;
        }

        private void dfs(int row, int col) {
            if (row < 0 || row >= m || col < 0 || col >= n) return;
            if (vis[row][col] || grid[row][col] == 0) return;
            vis[row][col] = true;
            curArea++;
            dfs(row + 1, col);
            dfs(row - 1, col);
            dfs(row, col + 1);
            dfs(row, col - 1);
        }
    }
}