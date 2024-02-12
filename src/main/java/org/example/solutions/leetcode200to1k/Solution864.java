package org.example.solutions.leetcode200to1k;

import java.util.*;

public class Solution864 {
    class Solution {
        static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        static final int inf = Integer.MAX_VALUE / 2;
        static final int maxK = 6;

        public int shortestPathAllKeys(String[] grid) {
            int m = grid.length, n = grid[0].length();
            int cnt = 0;
            int[][][] dist = new int[m][n][1 << maxK];
            Queue<int[]> qu = new ArrayDeque<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    Arrays.fill(dist[i][j], inf);
                    char ch = grid[i].charAt(j);
                    if (ch == '@') {
                        qu.offer(new int[]{i, j, 0});
                        dist[i][j][0] = 0;
                    } else if (Character.isLowerCase(ch)) {
                        cnt++;
                    }
                }
            }
            while (!qu.isEmpty()) {
                var t = qu.poll();
                int x = t[0], y = t[1], cur = t[2];
                int step = dist[x][y][cur];
                for (var dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                        continue;
                    }
                    char ch = grid[nx].charAt(ny);
                    // wall
                    if (ch == '#') {
                        continue;
                    }
                    // no key for the lock
                    if (Character.isUpperCase(ch) && (cur >> (ch - 'A') & 1) == 0) {
                        continue;
                    }
                    int ncur = cur;
                    // get a key
                    if (Character.isLowerCase(ch)) {
                        ncur |= 1 << (ch - 'a');
                    }
                    if (Integer.bitCount(ncur) == cnt) {
                        return step + 1;
                    }
                    if (step + 1 >= dist[nx][ny][ncur]) {
                        continue;
                    }
                    dist[nx][ny][ncur] = step + 1;
                    qu.offer(new int[]{nx, ny, ncur});
                }
            }
            return -1;
        }
    }
}