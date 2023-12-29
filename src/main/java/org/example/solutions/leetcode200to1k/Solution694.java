package org.example.solutions.leetcode200to1k;

import java.util.*;

import javafx.util.*;

public class Solution694 {
}

class Solution {
    private int curRowSrc, curColSrc, m, n;
    private int[][] grid;
    private boolean[][] vis;
    private Set<Pair<Integer, Integer>> curIsland; // 必须用JavaFx的Pair

    public int numDistinctIslands(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        vis = new boolean[m][n];
        Set<Set<Pair<Integer, Integer>>> islands = new HashSet<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                curIsland = new HashSet<>();
                curRowSrc = row;
                curColSrc = col;
                dfs(row, col);
                if (!curIsland.isEmpty()) islands.add(curIsland);
            }
        }
        return islands.size();
    }

    private void dfs(int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n) return;
        if (vis[row][col] || grid[row][col] == 0) return;
        vis[row][col] = true;
        curIsland.add(new Pair<>(row - curRowSrc, col - curColSrc));
        dfs(row + 1, col);
        dfs(row - 1, col);
        dfs(row, col + 1);
        dfs(row, col - 1);
    }
}
