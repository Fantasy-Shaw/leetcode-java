package org.example.solutions.leetcode501to1k;

import java.util.Arrays;

public class Solution787 {
    class Solution {
        static final int inf = Integer.MAX_VALUE / 2;

        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            int[][] graph = new int[n][n];
            for (int[] it : graph) {
                Arrays.fill(it, inf);
            }
            for (int i = 0; i < n; i++) {
                graph[i][i] = 0;
            }
            for (int[] f : flights) {
                graph[f[0]][f[1]] = f[2];
            }
            //Bellman Ford
            int[] dist = new int[n];
            Arrays.fill(dist, inf);
            dist[src] = 0;
            for (int lim = 0; lim <= k; lim++) {
                int[] preDist = dist.clone();
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        dist[j] = Math.min(dist[j], preDist[i] + graph[i][j]);
                    }
                }
            }
            return dist[dst] < inf ? dist[dst] : -1;
        }
    }
}