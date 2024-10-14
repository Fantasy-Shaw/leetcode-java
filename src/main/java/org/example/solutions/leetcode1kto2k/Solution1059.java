package org.example.solutions.leetcode1kto2k;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution1059 {
    class Solution {
        public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
            List<List<Integer>> graph = new ArrayList<>();
            int[] degrees = new int[n];
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                graph.get(edge[0]).add(edge[1]);
                graph.get(edge[1]).add(edge[0]);
                degrees[edge[0]]++;
            }
            if (degrees[destination] != 0) {
                return false;
            }
            Queue<Integer> qu = new ArrayDeque<>();
            qu.offer(destination);
            while (!qu.isEmpty()) {
                int cur = qu.poll();
                if (cur == source) {
                    return true;
                }
                for (int next : graph.get(cur)) {
                    degrees[next]--;
                    if (degrees[next] == 0) {
                        qu.offer(next);
                    }
                }
            }
            return false;
        }
    }
}