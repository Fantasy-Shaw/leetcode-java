package org.example.templates;

import java.util.*;

public
class Dijkstra {
    public static int[] getDistance(List<List<int[]>> graph, int start) {
        int n = graph.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(value -> value[1]));
        pq.offer(new int[]{start, 0});
        while (!pq.isEmpty()) {
            var t = pq.poll();
            int x = t[0], d = t[1];
            if (d > dist[x]) {
                continue;
            }
            for (var e : graph.get(x)) {
                int y = e[0], w = e[1];
                int nd = d + w;
                if (nd < dist[y]) {
                    dist[y] = nd;
                    pq.offer(new int[]{y, nd});
                }
            }
        }
        return dist;
    }
}
