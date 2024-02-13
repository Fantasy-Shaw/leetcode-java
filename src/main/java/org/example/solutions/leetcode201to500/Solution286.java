package org.example.solutions.leetcode201to500;

import java.util.*;

public class Solution286 {
    class Solution {
        private static final int EMPTY = Integer.MAX_VALUE, GATE = 0, WALL = -1;
        private static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public void wallsAndGates(int[][] rooms) {
            // BFS from doors
            Queue<int[]> qu = new ArrayDeque<>();
            int m = rooms.length, n = rooms[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (rooms[i][j] == GATE) {
                        qu.offer(new int[]{i, j});
                    }
                }
            }
            while (!qu.isEmpty()) {
                var p = qu.poll();
                int x = p[0], y = p[1];
                for (var dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || rooms[nx][ny] != EMPTY) {
                        continue;
                    }
                    rooms[nx][ny] = rooms[x][y] + 1;
                    qu.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
