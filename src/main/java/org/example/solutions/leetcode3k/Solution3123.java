package org.example.solutions.leetcode3k;

import org.example.templates.Dijkstra;

import java.util.ArrayList;
import java.util.List;

public class Solution3123 {
    class Solution {
        public boolean[] findAnswer(int n, int[][] edges) {
            List<List<int[]>> graph = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < edges.length; i++) {
                int x = edges[i][0], y = edges[i][1], w = edges[i][2];
                graph.get(x).add(new int[]{y, w, i});
                graph.get(y).add(new int[]{x, w, i});
            }
            int[] dist = Dijkstra.getDistance(graph, 0);
            boolean[] ans = new boolean[edges.length];
            if (dist[n - 1] == Integer.MAX_VALUE) {
                return ans;
            }
            boolean[] vis = new boolean[n];
            dfs(graph, n - 1, dist, vis, ans);
            return ans;
        }

        private void dfs(List<List<int[]>> graph, int x, int[] dist, boolean[] vis, boolean[] ans) {
            vis[x] = true;
            for (var e : graph.get(x)) {
                int y = e[0], w = e[1], i = e[2];
                if (dist[y] + w == dist[x]) {
                    ans[i] = true;
                    if (!vis[y]) {
                        dfs(graph, y, dist, vis, ans);
                    }
                }
            }
        }
    }
}