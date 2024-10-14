package org.example.solutions.leetcode1kto2k;

import java.util.ArrayList;
import java.util.List;

public class Solution1568 {
    class Solution {
        private int m, n;
        private int[][] grid;
        private boolean[][] vis;
        private Island curIsland;

        public int minDays(int[][] grid) {
            m = grid.length;
            n = grid[0].length;
            this.grid = grid;
            if (getIslands().size() != 1) {
                return 0;
            }
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    if (grid[row][col] == 1) {
                        grid[row][col] = 0;
                        if (getIslands().size() != 1) {
                            return 1;
                        }
                        grid[row][col] = 1;
                    }
                }
            }
            return 2;
        }

        private List<Island> getIslands() {
            vis = new boolean[m][n];
            List<Island> islands = new ArrayList<>();
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    curIsland = null;
                    dfs(row, col);
                    if (curIsland != null) islands.add(curIsland);
                }
            }
            return islands;
        }

        private void dfs(int row, int col) {
            if (row < 0 || row >= m || col < 0 || col >= n) return;
            if (vis[row][col] || grid[row][col] == 0) return;
            vis[row][col] = true;
            if (curIsland == null) curIsland = new Island();
            curIsland.addGrid(row, col);
            dfs(row + 1, col);
            dfs(row - 1, col);
            dfs(row, col + 1);
            dfs(row, col - 1);
        }

        private static class Island {
//            public int[] upLeftGrid = {Integer.MAX_VALUE, Integer.MAX_VALUE};
            public List<int[]> grids = new ArrayList<>();

            public void addGrid(int x, int y) {
//                upLeftGrid = new int[]{Math.min(upLeftGrid[0], x), Math.min(upLeftGrid[1], y)};
                grids.add(new int[]{x, y});
            }
        }
    }
}