package org.example.solutions.leetcode3k;

import java.util.*;

public class Solution3067 {
    class Solution {
        int signalSpeed;
        List<List<int[]>> graph;

        public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
            int n = edges.length + 1;
            this.signalSpeed = signalSpeed;
            graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            for (var e : edges) {
                int a = e[0], b = e[1], w = e[2];
                graph.get(a).add(new int[]{b, w});
                graph.get(b).add(new int[]{a, w});
            }
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                List<Integer> branches = new ArrayList<>();
                for (var e : graph.get(i)) {
                    int x = e[0], w = e[1];
                    branches.add(dfs(x, i, w));
                }
                int cur = 0;
                int m = branches.size();
                for (int x = 0; x < m; x++) {
                    for (int y = x + 1; y < m; y++) {
                        cur += (branches.get(x) * branches.get(y));
                    }
                }
                ans.add(cur);
            }
            return ans.stream().mapToInt(i -> i).toArray();
        }

        private int dfs(int x, int parent, int cur) {
            int ans = cur % signalSpeed == 0 ? 1 : 0;
            for (var e : graph.get(x)) {
                int y = e[0], w = e[1];
                if (y != parent) {
                    ans += dfs(y, x, cur + w);
                }
            }
            return ans;
        }
    }
}