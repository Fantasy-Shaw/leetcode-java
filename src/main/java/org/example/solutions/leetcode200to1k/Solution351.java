package org.example.solutions.leetcode200to1k;

import java.util.*;

public class Solution351 {
    class Solution {
        static final int[][] dirs = {
                {1, 0}, {-1, 0}, {0, 1}, {0, -1},
                {1, 1}, {1, -1}, {-1, 1}, {-1, -1},
                {1, 2}, {1, -2}, {-1, 2}, {-1, -2},
                {2, 1}, {2, -1}, {-2, 1}, {-2, -1}
        };

        static final int[][] dirSp = {
                {2, 0}, {-2, 0}, {0, 2}, {0, -2},
                {2, 2}, {2, -2}, {-2, 2}, {-2, -2}
        };

        public int numberOfPatterns(int m, int n) {
            int ans = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    boolean[][] vis = new boolean[3][3];
                    vis[i][j] = true;
                    ans += dfs(vis, i, j, m, n, 1);
                }
            }
            return ans;
        }

        private int dfs(boolean[][] vis, int x, int y, int m, int n, int cur) {
            if (cur > n) {
                return 0;
            }
            int ans = cur >= m ? 1 : 0;
            for (var dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (isValid(nx, ny) && !vis[nx][ny]) {
                    vis[nx][ny] = true;
                    ans += dfs(vis, nx, ny, m, n, cur + 1);
                    vis[nx][ny] = false;
                }
            }
            // 跳两个点，中间那个点之前被连过
            for (var dir : dirSp) {
                int midX = x + dir[0] / 2, midY = y + dir[1] / 2;
                if (isValid(midX, midY) && vis[midX][midY]) {
                    int nx = x + dir[0], ny = y + dir[1];
                    if (isValid(nx, ny) && !vis[nx][ny]) {
                        vis[nx][ny] = true;
                        ans += dfs(vis, nx, ny, m, n, cur + 1);
                        vis[nx][ny] = false;
                    }
                }
            }
            return ans;
        }

        private static boolean isValid(int x, int y) {
            return x >= 0 && x < 3 && y >= 0 && y < 3;
        }
    }
}