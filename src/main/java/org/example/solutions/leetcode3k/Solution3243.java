package org.example.solutions.leetcode3k;

import org.example.templates.Dijkstra;

import java.util.*;

public class Solution3243 {
    class Solution {
        public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
            List<Integer>[] graph = new List[n];
            Arrays.setAll(graph, i -> new ArrayList<>());
            for (int i = 1; i < n; i++) {
                graph[i - 1].add(i);
            }
            int m = queries.length;
            int[] ans = new int[m];
            for (int i = 0; i < m; i++) {
                int x = queries[i][0], y = queries[i][1];
                graph[x].add(y);
                int[] dis = Dijkstra.getDistance(graph, 0);
                ans[i] = dis[n - 1];
            }
            return ans;
        }
    }
}