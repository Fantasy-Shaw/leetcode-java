package org.example.solutions.leetcode200to1k;

import java.util.*;

public class Solution802 {
    class Solution {
        public List<Integer> eventualSafeNodes(int[][] graph) {
            int n = graph.length;
            List<List<Integer>> reversedGraph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                reversedGraph.add(new ArrayList<>());
            }
            int[] inDegrees = new int[n];
            for (int i = 0; i < n; i++) {
                inDegrees[i] = graph[i].length;
                for (int j : graph[i]) {
                    reversedGraph.get(j).add(i);
                }
            }
            Queue<Integer> qu = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                if (inDegrees[i] == 0) {
                    qu.offer(i);
                }
            }
            while (!qu.isEmpty()) {
                int j = qu.poll();
                for (int i : reversedGraph.get(j)) {
                    if (--inDegrees[i] == 0) {
                        qu.offer(i);
                    }
                }
            }
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (inDegrees[i] == 0) {
                    ans.add(i);
                }
            }
            return ans;
        }
    }
}