package org.example.solutions.leetcode501to1k;

import java.util.*;

public class Solution924 {
    class Solution {
        private Set<Integer> initSet;
        private int inits;

        public int minMalwareSpread(int[][] graph, int[] initial) {
            initSet = new HashSet<>();
            for (var x : initial) {
                initSet.add(x);
            }
            int n = graph.length;
            List<Integer>[] g = new List[n];
            Arrays.setAll(g, k -> new ArrayList<>());
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][j] == 1) {
                        g[i].add(j);
                    }
                }
            }
            Arrays.sort(initial);
            int maxSize = -1, id = -1;
            for (int x : initial) {
                inits = 0;
                boolean[] vis = new boolean[n];
                int size = dfs(g, x, vis);
                if (inits == 1 && size > maxSize) {
                    maxSize = size;
                    id = x;
                }
            }
            return id == -1 ? initial[0] : id;
        }

        private int dfs(List<Integer>[] g, int x, boolean[] vis) {
            int ans = 1;
            vis[x] = true;
            if (initSet.contains(x)) {
                inits++;
            }
            for (int y : g[x]) {
                if (!vis[y]) {
                    ans += dfs(g, y, vis);
                }
            }
            return ans;
        }
    }
}