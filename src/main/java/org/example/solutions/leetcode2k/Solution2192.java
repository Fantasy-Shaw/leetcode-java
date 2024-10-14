package org.example.solutions.leetcode2k;

import java.util.ArrayList;
import java.util.List;

public class Solution2192 {
    class Solution {
        public List<List<Integer>> getAncestors(int n, int[][] edges) {
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            for (var e : edges) {
                graph.get(e[0]).add(e[1]);
            }
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                ans.add(new ArrayList<>());
            }
            for (int u = 0; u < n; u++) {
                boolean[] vis = new boolean[n];
                for (var v : graph.get(u)) {
                    dfs(graph, ans, u, v, vis);
                }
            }
            return ans;
        }

        private void dfs(List<List<Integer>> graph, List<List<Integer>> ans, int ancestor, int v, boolean[] vis) {
            if (vis[v]) {
                return;
            }
            vis[v] = true;
            ans.get(v).add(ancestor);
            for (var w : graph.get(v)) {
                dfs(graph, ans, ancestor, w, vis);
            }
        }
    }
}