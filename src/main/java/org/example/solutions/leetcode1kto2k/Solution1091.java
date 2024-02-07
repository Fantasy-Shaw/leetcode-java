package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1091 {
    class Solution {
        static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        static final int inf = Integer.MAX_VALUE;

        public int shortestPathBinaryMatrix(int[][] grid) {
            if (grid[0][0] == 1) {
                return -1;
            }
            int m = grid.length, n = grid[0].length;
            int[][] dist = new int[m][n];
            for (var it : dist) {
                Arrays.fill(it, inf);
            }
            // int[3] : [x,y,step]
            Queue<int[]> qu = new ArrayDeque<>();
            qu.offer(new int[]{0, 0, 1});
            while (!qu.isEmpty()) {
                var p = qu.poll();
                int x = p[0], y = p[1], step = p[2];
                if (step >= dist[x][y]) {
                    continue;
                }
                dist[x][y] = step;
                for (var dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 0) {
                        qu.offer(new int[]{nx, ny, step + 1});
                    }
                }
            }
            return dist[m - 1][n - 1] < inf ? dist[m - 1][n - 1] : -1;
        }
    }
}