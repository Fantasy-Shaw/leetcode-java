package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1857 {
    class Solution {
        public int largestPathValue(String colors, int[][] edges) {
            int n = colors.length();
            int[] deg = new int[n];
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            for (var e : edges) {
                graph.get(e[0]).add(e[1]);
                deg[e[1]]++;
            }
            // Topology sort
            Queue<Integer> qu = new ArrayDeque<>();
//        List<Integer> order = new ArrayList<>();
            int orderSize = 0;
            for (int i = 0; i < n; i++) {
                if (deg[i] == 0) {
                    qu.offer(i);
                }
            }
            // dp
            int[][] dp = new int[n][26];
            while (!qu.isEmpty()) {
                int u = qu.poll();
//            order.add(u);
                orderSize++;
                dp[u][colors.charAt(u) - 'a']++;
                for (int v : graph.get(u)) {
                    if (--deg[v] == 0) {
                        qu.offer(v);
                    }
                    for (int k = 0; k < 26; k++) {
                        dp[v][k] = Math.max(dp[u][k], dp[v][k]);
                    }
                }
            }
//        if (order.size() != n) {
//            return -1;
//        }
            if (orderSize != n) {
                return -1;
            }
            int ans = Integer.MIN_VALUE;
            for (var arr : dp) {
                ans = Math.max(ans, Arrays.stream(arr).max().getAsInt());
            }
            return ans;
        }
    }
}