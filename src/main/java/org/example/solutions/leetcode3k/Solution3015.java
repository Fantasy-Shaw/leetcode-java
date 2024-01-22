package org.example.solutions.leetcode3k;

import java.util.*;

public class Solution3015 {
    class Solution {
        List<List<Integer>> graph;
        int[] result;
        int n;

        public int[] countOfPairs(int n, int x, int y) {
            this.n = n;
            graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 1; i < n; i++) {
                graph.get(i).add(i + 1);
                graph.get(i + 1).add(i);
            }
            if (x != y) {
                graph.get(x).add(y);
                graph.get(y).add(x);
            }
            result = new int[n];
            for (int i = 1; i <= n; i++) {
                Queue<Integer> qu = new ArrayDeque<>(List.of(i));
                boolean[] vis = new boolean[n + 1];
                int cost = 1;
                while (!qu.isEmpty()) {
                    int m = qu.size();
                    for (int j = 0; j < m; j++) {
                        int node = qu.poll();
                        vis[node] = true;
                        for (int nb : graph.get(node)) {
                            if (!vis[nb]) {
                                result[cost - 1]++;
                                vis[nb] = true;
                                qu.offer(nb);
                            }
                        }
                    }
                    cost++;
                }
            }
            return result;
        }
    }
}