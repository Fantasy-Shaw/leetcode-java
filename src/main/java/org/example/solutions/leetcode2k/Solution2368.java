package org.example.solutions.leetcode2k;

import java.util.*;

public class Solution2368 {
    class Solution {
        int ans;

        public int reachableNodes(int n, int[][] edges, int[] restricted) {
            ans = 0;
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            for (var e : edges) {
                graph.get(e[0]).add(e[1]);
                graph.get(e[1]).add(e[0]);
            }
            Set<Integer> restrictedSet = new HashSet<>();
            for (int i : restricted) {
                restrictedSet.add(i);
            }
            dfs(0, -1, graph, restrictedSet);
            return ans;
        }

        private void dfs(int cur, int parent, List<List<Integer>> graph, Set<Integer> restrictedSet) {
            ans++;
            for (int y : graph.get(cur)) {
                if (y != parent && !restrictedSet.contains(y)) {
                    dfs(y, cur, graph, restrictedSet);
                }
            }
        }
    }
}