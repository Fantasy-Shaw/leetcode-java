package org.example.solutions.leetcode2k;

import org.example.templates.Dijkstra;

import java.util.*;

public class Solution2642 {
    class Graph {
        private List<List<int[]>> graph;

        public Graph(int n, int[][] edges) {
            graph = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            for (var e : edges) {
                graph.get(e[0]).add(new int[]{e[1], e[2]});
            }
        }

        public void addEdge(int[] edge) {
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        public int shortestPath(int node1, int node2) {
            int[] dist = Dijkstra.getDistance(graph, node1);
            int ans = dist[node2];
            return ans < Integer.MAX_VALUE ? ans : -1;
        }
    }
}