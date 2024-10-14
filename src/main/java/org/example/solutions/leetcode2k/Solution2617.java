package org.example.solutions.leetcode2k;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2617 {
    class Solution1 {
        static final int inf = Integer.MAX_VALUE;
        int m, n;

        public int minimumVisitedCells(int[][] grid) {
            m = grid.length;
            n = grid[0].length;
            long[][] memo = new long[m][n];
            for (var it : memo) {
                Arrays.fill(it, -1);
            }
            long ans = dfs(grid, 0, 0, memo);
            return ans < inf ? (int) ans : -1;
        }

        private long dfs(int[][] grid, int i, int j, long[][] memo) {
            if (i == m - 1 && j == n - 1) {
                return 1;
            }
            if (i < 0 || i >= m || j < 0 || j >= n) {
                return inf;
            }
            if (memo[i][j] != -1) {
                return memo[i][j];
            }
            long ans = inf;
            for (int k = j + 1; k <= grid[i][j] + j; k++) {
                ans = Math.min(ans, 1 + dfs(grid, i, k, memo));
            }
            for (int k = i + 1; k <= grid[i][j] + i; k++) {
                ans = Math.min(ans, 1 + dfs(grid, k, j, memo));
            }
            memo[i][j] = ans;
            return ans;
        }
    }

    class Solution {
        public int minimumVisitedCells(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int mn = 0;
            List<List<int[]>> colSts = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                colSts.add(new ArrayList<>());
            }
            List<int[]> rowSt = new ArrayList<>();
            for (int i = m - 1; i >= 0; i--) {
                rowSt.clear();
                for (int j = n - 1; j >= 0; j--) {
                    var colSt = colSts.get(j);
                    mn = i < m - 1 || j < n - 1 ? Integer.MAX_VALUE : 1;
                    if (grid[i][j] > 0) {
                        int k = lowerBound(rowSt, grid[i][j] + j);
                        if (0 <= k && k < rowSt.size()) {
                            mn = rowSt.get(k)[0] + 1;
                        }
                        k = lowerBound(colSt, grid[i][j] + i);
                        if (0 <= k && k < colSt.size()) {
                            mn = Math.min(mn, colSt.get(k)[0] + 1);
                        }
                    }
                    if (mn < Integer.MAX_VALUE) {
                        while (!rowSt.isEmpty() && rowSt.getLast()[0] >= mn) {
                            rowSt.removeLast();
                        }
                        rowSt.add(new int[]{mn, j});
                        while (!colSt.isEmpty() && colSt.getLast()[0] >= mn) {
                            colSt.removeLast();
                        }
                        colSt.add(new int[]{mn, i});
                    }
                }
            }
            return mn < Integer.MAX_VALUE ? mn : -1;
        }

        static int lowerBound(List<int[]> list, int target) {
            int l = 0, r = list.size();
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (list.get(mid)[1] > target) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l;
        }
    }
}