package org.example.solutions.leetcode3k;

import java.util.*;

public class Solution3310 {
    static
    class Solution {
        public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
            boolean[] vis = new boolean[n], visK = new boolean[n];
            List<Integer>[] graph = new ArrayList[n];
            Arrays.setAll(graph, i -> new ArrayList<>());
            List<Integer>[] rev = new ArrayList[n];
            Arrays.setAll(rev, i -> new ArrayList<>());
            for (var e : invocations) {
                graph[e[0]].add(e[1]);
                rev[e[1]].add(e[0]);
            }
            dfs(graph, k, vis, visK);
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (visK[i]) {
                    set.add(i);
                }
            }
            Set<Integer> ans = new HashSet<>();
            for (int i = 0; i < n; i++) {
                ans.add(i);
            }
            for (int x : set) {
                for (int y : rev[x]) {
                    if (!set.contains(y)) {
                        return new ArrayList<>(ans);
                    }
                }
            }
            ans.removeAll(set);
            return new ArrayList<>(ans);
        }

        private void dfs(List<Integer>[] graph, int x, boolean[] vis, boolean[] visK) {
            if (vis[x]) {
                return;
            }
            vis[x] = true;
            visK[x] = true;
            for (int y : graph[x]) {
                dfs(graph, y, vis, visK);
            }
        }
    }
}