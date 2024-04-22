package org.example.solutions.leetcode3k;

import java.util.*;

public class Solution3112 {
    class Solution {
        public int[] minimumTime(int n, int[][] edges, int[] disappear) {
            List<int[]>[] graph = new List[n];
            Arrays.setAll(graph, k -> new ArrayList<>());
            for (var e : edges) {
                graph[e[0]].add(new int[]{e[1], e[2]});
                graph[e[1]].add(new int[]{e[0], e[2]});
            }
            int[] ans = new int[n];
            Arrays.fill(ans, Integer.MAX_VALUE);
            ans[0] = 0;
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(value -> value[1]));
            pq.offer(new int[]{0, 0, 0});
            while (!pq.isEmpty()) {
                var e = pq.poll();
                int x = e[0], d = e[1], time = e[2];
                if (d > ans[x]) {
                    continue;
                }
                for (var edge : graph[x]) {
                    int y = edge[0], w = edge[1];
                    int nd = d + w, nt = time + w;
                    if (nd < ans[y] && nt < disappear[y]) {
                        ans[y] = nd;
                        pq.offer(new int[]{y, nd, nt});
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                if (ans[i] == Integer.MAX_VALUE) {
                    ans[i] = -1;
                }
            }
            return ans;
        }
    }
}