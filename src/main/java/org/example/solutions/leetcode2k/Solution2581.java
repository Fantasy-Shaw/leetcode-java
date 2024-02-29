package org.example.solutions.leetcode2k;

import java.util.*;

public class Solution2581 {
    class Solution {
        List<List<Integer>> graph;
        Set<Long> set;
        int k, ans, cnt0;

        public int rootCount(int[][] edges, int[][] guesses, int k) {
            this.k = k;
            ans = 0;
            cnt0 = 0;
            int n = edges.length + 1;
            graph = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            for (var e : edges) {
                graph.get(e[0]).add(e[1]);
                graph.get(e[1]).add(e[0]);
            }
            // long : pair<int,int>
            set = new HashSet<>();
            for (var g : guesses) {
                set.add((long) g[0] << 32 | g[1]);
            }
            dfs(0, -1);
            reRoot(0, -1, cnt0);
            return ans;
        }

        private void dfs(int x, int parent) {
            for (int y : graph.get(x)) {
                if (y != parent) {
                    long pair = (long) x << 32 | y;
                    if (set.contains(pair)) {
                        cnt0++;
                    }
                    dfs(y, x);
                }
            }
        }

        private void reRoot(int x, int parent, int cnt) {
            if (cnt >= k) {
                ans++;
            }
            for (int y : graph.get(x)) {
                if (y != parent) {
                    int cnt1 = cnt;
                    if (set.contains((long) x << 32 | y)) {
                        cnt1--;
                    }
                    if (set.contains((long) y << 32 | x)) {
                        cnt1++;
                    }
                    reRoot(y, x, cnt1);
                }
            }
        }
    }
}