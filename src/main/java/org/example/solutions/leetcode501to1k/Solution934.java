package org.example.solutions.leetcode501to1k;

import java.util.*;

public class Solution934 {
    class Solution {
        public int shortestBridge(int[][] grid) {
            int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            int n = grid.length;
            Queue<int[]> qu = new ArrayDeque<>();
            List<int[]> island1 = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        qu.offer(new int[]{i, j});
                        grid[i][j] = -1;
                        while (!qu.isEmpty()) {
                            var t = qu.poll();
                            island1.add(t);
                            int x = t[0], y = t[1];
                            for (int[] dir : dirs) {
                                int nx = x + dir[0], ny = y + dir[1];
                                if (nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                                    qu.offer(new int[]{nx, ny});
                                    grid[nx][ny] = -1;
                                }
                            }
                        }
                        qu.addAll(island1);
                        int step = 0;
                        while (!qu.isEmpty()) {
                            int m = qu.size();
                            for (int k = 0; k < m; k++) {
                                var t = qu.poll();
                                int x = t[0], y = t[1];
                                for (int[] dir : dirs) {
                                    int nx = x + dir[0], ny = y + dir[1];
                                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                                        if (grid[nx][ny] == 0) {
                                            qu.offer(new int[]{nx, ny});
                                            grid[nx][ny] = -1;
                                        } else if (grid[nx][ny] == 1) {
                                            return step;
                                        }
                                    }
                                }
                            }
                            step++;
                        }
                    }
                }
            }
            return -1;
        }
    }
}