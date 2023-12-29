package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1905 {
    class Solution {
        private int m, n;
        private int[][] grid;
        private boolean[][] vis;
        private List<int[]> curSubIsland;

        private void dfs(int row, int col) {
            if (row < 0 || row >= m || col < 0 || col >= n) return;
            if (vis[row][col] || grid[row][col] == 0) return;
            vis[row][col] = true;
            if (curSubIsland == null) curSubIsland = new ArrayList<>();
            curSubIsland.add(new int[]{row, col});
            dfs(row + 1, col);
            dfs(row - 1, col);
            dfs(row, col + 1);
            dfs(row, col - 1);
        }

        public int countSubIslands(int[][] grid1, int[][] grid2) {
            m = grid2.length;
            n = grid2[0].length;
            this.grid = grid2;
            vis = new boolean[m][n];
            List<List<int[]>> subIslands2 = new ArrayList<>();
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    curSubIsland = null;
                    dfs(row, col);
                    if (curSubIsland != null) subIslands2.add(curSubIsland);
                }
            }
            //check
            int ans = subIslands2.size();
            for (var sub : subIslands2) {
                for (var pos : sub) {
                    if (grid1[pos[0]][pos[1]] == 0) {
                        ans--;
                        break;
                    }
                }
            }
            return ans;
        }
    }
}