package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1334 {
    class Solution {
        static final int inf = Integer.MAX_VALUE / 2;
        int[][][] memo;
        int[][] graph;

        public int findTheCity(int n, int[][] edges, int distanceThreshold) {
            graph = new int[n][n];
            memo = new int[n][n][n];
            for (var it : graph) {
                Arrays.fill(it, inf);
            }
            for (var e : edges) {
                int x = e[0], y = e[1], w = e[2];
                graph[x][y] = graph[y][x] = w;
            }
            int ans = 0, minCnt = n;
            for (int i = 0; i < n; i++) {
                int cnt = 0;
                for (int j = 0; j < n; j++) {
                    if (j != i && dfs(n - 1, i, j) <= distanceThreshold) {
                        cnt++;
                    }
                }
                if (cnt <= minCnt) {
                    minCnt = cnt;
                    ans = i;
                }
            }
            return ans;
        }

        private int dfs(int k, int i, int j) { // Floyd
            if (k < 0) {
                return graph[i][j];
            }
            if (memo[k][i][j] != 0) {
                return memo[k][i][j];
            }
            int ans = Math.min(dfs(k - 1, i, j), dfs(k - 1, i, k) + dfs(k - 1, k, j));
            memo[k][i][j] = ans;
            return ans;
        }
    }
}