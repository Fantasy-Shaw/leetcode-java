package org.example.solutions.leetcode1kto2k;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution1514 { // Dijkstra
    class Solution {
        public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
            List<List<Pair<Integer, Double>>> graph = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < edges.length; i++) {
                graph.get(edges[i][0]).add(new Pair<>(edges[i][1], succProb[i]));
                graph.get(edges[i][1]).add(new Pair<>(edges[i][0], succProb[i]));
            }
            PriorityQueue<Pair<Integer, Double>> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> -a.second));
            double[] dist = new double[n];
            pq.offer(new Pair<>(start_node, 1.0));
            dist[start_node] = 1.0;
            while (!pq.isEmpty()) {
                var pair = pq.poll();
                double p = pair.second;
                int id = pair.first;
                if (p < dist[id]) {
                    continue;
                }
                for (var next : graph.get(id)) {
                    double pNext = next.second;
                    int idNext = next.first;
                    if (dist[idNext] < dist[id] * pNext) {
                        dist[idNext] = dist[id] * pNext;
                        pq.offer(new Pair<>(idNext, dist[idNext]));
                    }
                }
            }
            return dist[end_node];
        }

        static class Pair<_Tp1, _Tp2> {
            public _Tp1 first;
            public _Tp2 second;

            public Pair(_Tp1 first, _Tp2 second) {
                this.first = first;
                this.second = second;
            }
        }
    }
}