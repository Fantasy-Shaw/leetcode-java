package org.example.solutions.leetcode201to500;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution407 {
    class Solution {
        // Dijkstra + PriorityQueue
        public int trapRainWater(int[][] heightMap) {
            int m = heightMap.length, n = heightMap[0].length;
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
            boolean[][] vis = new boolean[m][n];
            for (int i = 0; i < n; i++) {
                pq.add(new int[]{0, i, heightMap[0][i]});
                pq.add(new int[]{m - 1, i, heightMap[m - 1][i]});
                vis[0][i] = vis[m - 1][i] = true;
            }
            for (int i = 1; i < m - 1; i++) {
                pq.add(new int[]{i, 0, heightMap[i][0]});
                pq.add(new int[]{i, n - 1, heightMap[i][n - 1]});
                vis[i][0] = vis[i][n - 1] = true;
            }
            int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            int ans = 0;
            while (!pq.isEmpty()) {
                var t = pq.poll();
                int x = t[0], y = t[1], h = t[2];
                for (var d : dirs) {
                    int nx = x + d[0], ny = y + d[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                    if (vis[nx][ny]) continue;
                    if (h > heightMap[nx][ny]) {
                        ans += (h - heightMap[nx][ny]);
                    }
                    pq.add(new int[]{nx, ny, Math.max(heightMap[nx][ny], h)});
                    vis[nx][ny] = true;
                }
            }
            return ans;
        }
    }
}