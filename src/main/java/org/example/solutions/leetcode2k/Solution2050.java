package org.example.solutions.leetcode2k;

import java.util.*;

public class Solution2050 {
    class Solution {
        public int minimumTime(int n, int[][] relations, int[] time) {
            List<List<Integer>> graph = new ArrayList<>();
            int[] inDegrees = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            for (var r : relations) {
                graph.get(r[0]).add(r[1]);
                inDegrees[r[1]]++;
            }
            Queue<Integer> qu = new ArrayDeque<>();
            for (int i = 1; i <= n; i++) {
                if (inDegrees[i] == 0) {
                    qu.offer(i);
                }
            }
            int ans = 0;
            int[] f = new int[n + 1];
            while (!qu.isEmpty()) {
                int x = qu.poll();
                f[x] += time[x - 1];
                ans = Math.max(ans, f[x]);
                for (int y : graph.get(x)) {
                    f[y] = Math.max(f[y], f[x]);
                    if (--inDegrees[y] == 0) {
                        qu.offer(y);
                    }
                }
            }
            return ans;
        }
    }
}