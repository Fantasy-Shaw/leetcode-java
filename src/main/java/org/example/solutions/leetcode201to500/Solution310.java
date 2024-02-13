package org.example.solutions.leetcode201to500;

import java.util.*;

public class Solution310 {
    class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            if (n == 1) {
                return List.of(0);
            } else if (n == 2) {
                return List.of(0, 1);
            }
            int[] inDegrees = new int[n];
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            for (var edge : edges) {
                graph.get(edge[0]).add(edge[1]);
                inDegrees[edge[1]]++;
                graph.get(edge[1]).add(edge[0]);
                inDegrees[edge[0]]++;
            }
            Queue<Integer> qu = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                if (inDegrees[i] == 1) {
                    qu.offer(i);
                }
            }
            int reservedNodes = n;
            while (reservedNodes > 2) {
                int cur = qu.size();
                reservedNodes -= cur;
                for (int i = 0; i < cur; i++) {
                    int t = qu.poll();
                    inDegrees[t] = 0;
                    for (int x : graph.get(t)) {
                        if (inDegrees[x] != 0) {
                            inDegrees[x]--;
                            if (inDegrees[x] == 1) {
                                qu.offer(x);
                            }
                        }
                    }
                }
            }
            return new ArrayList<>(qu);
        }
    }
}