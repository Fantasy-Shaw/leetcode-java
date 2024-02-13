package org.example.solutions.leetcode201to500;

import java.util.*;

public class Solution317 {
    class Solution {
        private static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public int shortestDistance(int[][] grid) {
            int res = Integer.MAX_VALUE, val = 0;
            int m = grid.length, n = grid[0].length;
            int[][] sum = new int[m][n], dist = new int[m][n];
            for (int i = 0; i < m; i++) {
                // Only clone-1d is deep copy.
                sum[i] = grid[i].clone();
                dist[i] = grid[i].clone();
            }
            // int[2] : pair
            Queue<int[]> qu = new ArrayDeque<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        res = Integer.MAX_VALUE;
                        qu.offer(new int[]{i, j});
                        while (!qu.isEmpty()) {
                            int a = qu.peek()[0], b = qu.peek()[1];
                            qu.poll();
                            for (int k = 0; k < 4; k++) {
                                int x = a + dirs[k][0], y = b + dirs[k][1];
                                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == val) {
                                    --grid[x][y];
                                    dist[x][y] = dist[a][b] + 1;
                                    sum[x][y] += (dist[x][y] - 1);
                                    qu.offer(new int[]{x, y});
                                    res = Math.min(res, sum[x][y]);
                                }
                            }
                        }
                        --val;
                    }
                }
            }
            return res == Integer.MAX_VALUE ? -1 : res;
        }
    }
}