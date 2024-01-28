package org.example.solutions.leetcode1to200;

public class Solution200 {
    class Solution {
        char[][] grid;
        int m, n;

        public int numIslands(char[][] grid) {
            this.grid = grid;
            m = grid.length;
            n = grid[0].length;
            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        ans++;
                        dfs(i, j);
                    }
                }
            }
            return ans;
        }

        private void dfs(int x, int y) {
            if (x < 0 || x >= m || y < 0 || y >= n) {
                return;
            }
            if (grid[x][y] == '0') {
                return;
            }
            grid[x][y] = '0';
            dfs(x - 1, y);
            dfs(x + 1, y);
            dfs(x, y - 1);
            dfs(x, y + 1);
        }
    }
}