package org.example.solutions.leetcode1kto2k;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution1926 {
    class Solution {
        static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public int nearestExit(char[][] maze, int[] entrance) {
            int m = maze.length, n = maze[0].length;
            // int[3]: [x,y,step]
            Queue<int[]> qu = new ArrayDeque<>();
            qu.offer(new int[]{entrance[0], entrance[1], 0});
            maze[entrance[0]][entrance[1]] = '+';
            while (!qu.isEmpty()) {
                var t = qu.poll();
                int x = t[0], y = t[1], step = t[2];
                for (int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                        continue;
                    }
                    if (maze[nx][ny] == '.') {
                        if (nx == 0 || nx == m - 1 || ny == 0 || ny == n - 1) {
                            return step + 1;
                        }
                        qu.offer(new int[]{nx, ny, step + 1});
                        maze[nx][ny] = '+';
                    }
                }
            }
            return -1;
        }
    }
}