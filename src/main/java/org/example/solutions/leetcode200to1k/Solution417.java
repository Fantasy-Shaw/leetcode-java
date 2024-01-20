package org.example.solutions.leetcode200to1k;

import java.util.*;

public class Solution417 {
    class Solution {
        static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] heights;
        int m, n;

        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            this.heights = heights;
            m = heights.length;
            n = heights[0].length;
            boolean[][] po = new boolean[m][n], ao = new boolean[m][n];
            Queue<int[]> quP = new ArrayDeque<>(), quA = new ArrayDeque<>();
            for (int i = 0; i < m; i++) {
                po[i][0] = true;
                quP.offer(new int[]{i, 0});
                ao[i][n - 1] = true;
                quA.offer(new int[]{i, n - 1});
            }
            for (int j = 0; j < n; j++) {
                po[0][j] = true;
                quP.offer(new int[]{0, j});
                ao[m - 1][j] = true;
                quA.offer(new int[]{m - 1, j});
            }
            bfs(quP, po);
            bfs(quA, ao);
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (po[i][j] && ao[i][j]) {
                        ans.add(List.of(i, j));
                    }
                }
            }
            return ans;
        }

        private void bfs(Queue<int[]> qu, boolean[][] vis) {
            while (!qu.isEmpty()) {
                var t = qu.poll();
                int x = t[0], y = t[1], h = heights[x][y];
                for (var d : dirs) {
                    int nx = x + d[0], ny = y + d[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                        continue;
                    }
                    if (vis[nx][ny] || heights[nx][ny] < h) {
                        continue;
                    }
                    qu.offer(new int[]{nx, ny});
                    vis[nx][ny] = true;
                }
            }
        }
    }
}