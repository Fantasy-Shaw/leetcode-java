package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1976 {
    class Solution {
        static final int mod = (int) 1e9 + 7;

        public int countPaths(int n, int[][] roads) {
            List<List<int[]>> graph = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            for (var e : roads) {
                int u = e[0], v = e[1], w = e[2];
                graph.get(u).add(new int[]{v, w});
                graph.get(v).add(new int[]{u, w});
            }
            long[] dist = new long[n];
            Arrays.fill(dist, Long.MAX_VALUE);
            dist[0] = 0;
            PriorityQueue<Adj> pq = new PriorityQueue<>(Comparator.comparingLong(value -> value.d));
            pq.offer(new Adj(0, 0));
            long[] dp = new long[n];
            dp[0] = 1;
            while (!pq.isEmpty()) {
                var t = pq.poll();
                int x = t.u;
                long d = t.d;
                if (d > dist[x]) {
                    continue;
                }
                for (var e : graph.get(x)) {
                    int y = e[0];
                    long nd = d + e[1];
                    if (nd < dist[y]) {
                        dist[y] = nd;
                        dp[y] = dp[x];
                        pq.offer(new Adj(y, nd));
                    } else if (nd == dist[y]) {
                        dp[y] = (dp[x] + dp[y]) % mod;
                    }
                }
            }
            return (int) dp[n - 1];
        }

        static class Adj {
            public int u;
            public long d;

            Adj(int u, long d) {
                this.u = u;
                this.d = d;
            }
        }
    }
}