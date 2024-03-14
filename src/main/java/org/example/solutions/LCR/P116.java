package org.example.solutions.LCR;

import java.util.*;

public class P116 {
    class Solution {
        public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
            int n = nums.length;
            int[] deg = new int[n + 1];
            List<Set<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new HashSet<>());
            }
            for (int[] seq : sequences) {
                for (int i = 0; i < seq.length - 1; i++) {
                    int u = seq[i], v = seq[i + 1];
                    if (graph.get(u).add(v)) {
                        deg[v]++;
                    }
                }
            }
            Queue<Integer> qu = new ArrayDeque<>();
            for (int i = 1; i <= n; i++) {
                if (deg[i] == 0) {
                    qu.offer(i);
                }
            }
            while (!qu.isEmpty()) {
                if (qu.size() > 1) {
                    return false;
                }
                int u = qu.poll();
                for (int v : graph.get(u)) {
                    if (--deg[v] == 0) {
                        qu.offer(v);
                    }
                }
            }
            return true;
        }
    }
}