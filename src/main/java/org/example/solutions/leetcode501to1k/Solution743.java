package org.example.solutions.leetcode501to1k;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution743 {
    class Solution {
        static final int inf = Integer.MAX_VALUE / 2;

        public int networkDelayTime(int[][] times, int n, int k) { // Dijkstra + PriorityQueue
            List<List<int[]>> graph = new ArrayList<>(n);
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            for (var e : times) {
                int x = e[0], y = e[1], w = e[2];
                graph.get(x).add(new int[]{y, w});
            }
            int[] dist = new int[n + 1];
            Arrays.fill(dist, inf);
            dist[k] = 0;
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            pq.offer(new int[]{k, 0});
            while (!pq.isEmpty()) {
                int[] pair = pq.poll();
                int x = pair[0], w = pair[1];
                if (dist[x] < w) {
                    continue;
                }
                for (int[] e : graph.get(x)) {
                    int y = e[0], d = dist[x] + e[1];
                    if (d < dist[y]) {
                        dist[y] = d;
                        pq.offer(new int[]{y, d});
                    }
                }
            }
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                ans = Math.max(ans, dist[i]);
            }
            return ans == inf ? -1 : ans;
        }
    }
}