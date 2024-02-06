package org.example.solutions.leetcode200to1k;

import java.util.*;

public class Solution542 {
    class Solution {
        // Spread from zeros. O(mn)
        static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public int[][] updateMatrix(int[][] mat) {
            int m = mat.length, n = mat[0].length;
            int[][] ans = new int[m][n];
            boolean[][] vis = new boolean[m][n];
            Queue<int[]> qu = new ArrayDeque<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 0) {
                        qu.offer(new int[]{i, j});
                        vis[i][j] = true;
                    }
                }
            }
            int step = 1;
            while (!qu.isEmpty()) {
                int size = qu.size();
                for (int k = 0; k < size; k++) {
                    var t = qu.poll();
                    int x = t[0], y = t[1];
                    for (var d : dirs) {
                        int nx = x + d[0];
                        int ny = y + d[1];
                        if (nx >= 0 && nx < m && ny >= 0 && ny < n && !vis[nx][ny]) {
                            ans[nx][ny] = step;
                            qu.offer(new int[]{nx, ny});
                            vis[nx][ny] = true;
                        }
                    }
                }
                step++;
            }
            return ans;
        }
    }
}