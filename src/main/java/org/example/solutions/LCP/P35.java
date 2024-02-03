package org.example.solutions.LCP;

import java.util.*;

public class P35 {
    class Solution {
        final int inf = Integer.MAX_VALUE / 2;

        public int electricCarPlan(int[][] paths, int cnt, int start, int end, int[] charge) {
            int n = charge.length;
            int[][] dist = new int[n][cnt + 1];
            for (var it : dist) {
                Arrays.fill(it, inf);
            }
            List<List<int[]>> graph = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int[] e : paths) {
                int u = e[0], v = e[1], w = e[2];
                graph.get(u).add(new int[]{v, w});
                graph.get(v).add(new int[]{u, w});
            }
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
            pq.offer(new int[]{0, start, 0});
            while (!pq.isEmpty()) {
                var x = pq.poll();
                int t = x[0], u = x[1], c = x[2];
                if (t > dist[u][c]) {
                    continue;
                }
                if (u == end) {
                    return t;
                }
                if (c < cnt) {
                    int nt = t + charge[u];
                    if (nt < dist[u][c + 1]) {
                        dist[u][c + 1] = nt;
                        pq.offer(new int[]{nt, u, c + 1});
                    }
                }
                for (int[] nb : graph.get(u)) {
                    int v = nb[0], w = nb[1];
                    if (c >= w && t + w < dist[v][c - w]) {
                        dist[v][c - w] = t + w;
                        pq.offer(new int[]{t + w, v, c - w});
                    }
                }
            }
            return -1;
        }
    }

}