package org.example.solutions.leetcode501to1k;

import java.util.*;

public class Solution851 {
    class Solution {
        public int[] loudAndRich(int[][] richer, int[] quiet) {
            int n = quiet.length;
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            int[] inDegrees = new int[n], ans = new int[n];
            for (int[] r : richer) {
                graph.get(r[0]).add(r[1]);
                inDegrees[r[1]]++;
            }
            for (int i = 0; i < n; i++) {
                ans[i] = i;
            }
            Queue<Integer> qu = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                if (inDegrees[i] == 0) {
                    qu.offer(i);
                }
            }
            while (!qu.isEmpty()) {
                int x = qu.poll();
                for (int y : graph.get(x)) {
                    if (quiet[ans[x]] < quiet[ans[y]]) {
                        ans[y] = ans[x];
                    }
                    if (--inDegrees[y] == 0) {
                        qu.offer(y);
                    }
                }
            }
            return ans;
        }
    }
}