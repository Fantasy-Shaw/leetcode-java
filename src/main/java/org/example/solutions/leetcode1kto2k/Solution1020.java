package org.example.solutions.leetcode1kto2k;

public class Solution1020 {
    class Solution {
        int[][] grid;
        int m, n;

        public int numEnclaves(int[][] grid) {
            this.grid = grid;
            m = grid.length;
            n = grid[0].length;
            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        int[] t = dfs(i, j);
                        int size = t[0];
                        int visBoundary = t[1];
                        if (visBoundary == 0) {
                            ans += size;
                        }
                    }
                }
            }
            return ans;
        }

        private int[] dfs(int x, int y) {
            if (x < 0 || x >= m || y < 0 || y >= n) {
                return new int[]{0, 0};
            }
            if (grid[x][y] == 0) {
                return new int[]{0, 0};
            }
            grid[x][y] = 0;
            int size = 1;
            int visBoundary = (x == 0 || x == m - 1 || y == 0 || y == n - 1) ? 1 : 0;
            int[] t1 = dfs(x - 1, y), t2 = dfs(x + 1, y), t3 = dfs(x, y - 1), t4 = dfs(x, y + 1);
            return new int[]{
                    size + t1[0] + t2[0] + t3[0] + t4[0],
                    visBoundary | t1[1] | t2[1] | t3[1] | t4[1]
            };

        }
    }
}