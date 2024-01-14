package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1129 {
    class Solution {
        private int inf = Integer.MAX_VALUE / 2;

        public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
            List<List<List<Integer>>> graph = new ArrayList<>(2);
            for (int i = 0; i < 2; i++) {
                graph.add(new ArrayList<>(n));
                for (int j = 0; j < n; j++) {
                    graph.get(i).add(new ArrayList<>());
                }
            }
            for (int[] r : redEdges) {
                graph.getFirst().get(r[0]).add(r[1]);
            }
            for (int[] b : blueEdges) {
                graph.getLast().get(b[0]).add(b[1]);
            }
            int[][] dist = new int[2][n];
            for (int i = 0; i < 2; i++) {
                Arrays.fill(dist[i], inf);
            }
            // int[2]: [node, color]
            Queue<int[]> qu = new ArrayDeque<>();
            dist[0][0] = 0;
            dist[1][0] = 0;
            qu.offer(new int[]{0, 0});
            qu.offer(new int[]{0, 1});
            while (!qu.isEmpty()) {
                int[] pair = qu.poll();
                int x = pair[0], color = pair[1], oppoColor = 1 - pair[1];
                for (int y : graph.get(oppoColor).get(x)) {
                    if (dist[oppoColor][y] != inf) {
                        continue;
                    }
                    dist[oppoColor][y] = dist[color][x] + 1;
                    qu.offer(new int[]{y, oppoColor});
                }
            }
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                ans[i] = Math.min(dist[0][i], dist[1][i]);
                if (ans[i] == inf) ans[i] = -1;
            }
            return ans;
        }
    }
}