package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1192 {
    class Solution { // Tarjan template
        List<List<Integer>> graph, ans;
        int[] time, low;
        int curTime;

        public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
            time = new int[n];
            low = new int[n];
            graph = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            for (var edge : connections) {
                graph.get(edge.get(0)).add(edge.get(1));
                graph.get((edge.get(1))).add(edge.get(0));
            }
            ans = new ArrayList<>();
            curTime = 0;
            dfs(0, 0);
            return ans;
        }

        private void dfs(int u, int pa) {
            low[u] = time[u] = ++curTime;
            for (int v : graph.get(u)) {
                if (time[v] == 0) { // Not visited
                    dfs(v, u);
                    low[u] = Math.min(low[u], low[v]);
                    if (low[v] > time[u]) { // bridge
                        ans.add(Arrays.asList(u, v));
                    }
                } else if (time[v] < time[u] && v != pa) { // v is visited before u, and skip it.
                    low[u] = Math.min(low[u], time[v]);
                }
            }
        }
    }
}