package org.example.solutions.leetcode501to1k;

import java.util.Arrays;

public class Solution928 {
    class Solution {
        int node, size;

        public int minMalwareSpread(int[][] graph, int[] initial) {
            int n = graph.length;
            boolean[] isInfected = new boolean[n];
            for (int x : initial) {
                isInfected[x] = true;
            }
            boolean[] vis = new boolean[n];
            int[] cnt = new int[n];
            for (int i = 0; i < n; i++) {
                if (vis[i] || isInfected[i]) continue;
                node = -1;
                size = 0;
                dfs(graph, i, isInfected, vis);
                if (node >= 0) {
                    cnt[node] += size;
                }
            }
            int mxCnt = 0, ans = -1;
            for (int i = 0; i < n; i++) {
                if (cnt[i] == 0) continue;
                if (cnt[i] > mxCnt) {
                    mxCnt = cnt[i];
                    ans = i;
                }
            }
            return ans >= 0 ? ans : Arrays.stream(initial).min().getAsInt();
        }

        private void dfs(int[][] graph, int x, boolean[] isInfected, boolean[] vis) {
            vis[x] = true;
            size++;
            for (int y = 0; y < graph.length; y++) {
                if (graph[x][y] == 0) continue;
                if (isInfected[y]) {
                    if (node != -2 && y != node) {
                        node = (node == -1) ? y : -2;
                    }
                } else if (!vis[y]) {
                    dfs(graph, y, isInfected, vis);
                }
            }
        }
    }
}