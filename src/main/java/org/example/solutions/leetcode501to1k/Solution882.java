package org.example.solutions.leetcode501to1k;

import org.example.templates.Dijkstra;

import java.util.ArrayList;
import java.util.List;

public class Solution882 {
    class Solution {
        public int reachableNodes(int[][] edges, int maxMoves, int n) {
            // [v,cnt]
            List<List<int[]>> graph = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            for (var e : edges) {
                int u = e[0], v = e[1], cnt = e[2];
                // +1 : The vertex is also a node.
                graph.get(u).add(new int[]{v, cnt + 1});
                graph.get(v).add(new int[]{u, cnt + 1});
            }
            int[] dist = Dijkstra.getDistance(graph, 0);
            int ans = 0;
            for (int d : dist) {
                if (d <= maxMoves) {
                    ans++;  // The vertex is available in <= maxMoves
                }
            }
            for (var e : edges) {
                int u = e[0], v = e[1], cnt = e[2];
                // 0 -> u takes dist[u], and maxMoves - dist[u] nodes on edge <u,v> can be colored.
                int a = Math.max(maxMoves - dist[u], 0);
                int b = Math.max(maxMoves - dist[v], 0);
                ans += Math.min(cnt, a + b);
            }
            return ans;
        }
    }
}