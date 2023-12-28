package org.example.solutions.leetcode200to1k;

import java.util.*;

public class Solution444 {
    class Solution {
        public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
            int n = nums.length;
            int[] inDegrees = new int[n + 1];
            List<Set<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new HashSet<>());
            }
            for (var seq : sequences) {
                int m = seq.size();
                for (int i = 1; i < m; i++) {
                    int prev = seq.get(i - 1), next = seq.get(i);
                    // true if this set did not already contain the specified element
                    if (graph.get(prev).add(next)) {
                        inDegrees[next]++;
                    }
                }
            }
            Queue<Integer> qu = new ArrayDeque<>();
            for (int i = 1; i <= n; i++) {
                if (inDegrees[i] == 0) {
                    qu.offer(i);
                }
            }
            while (!qu.isEmpty()) {
                if (qu.size() > 1) {
                    return false; // 超序列的下一个数字有多种可能
                }
                for (int next : graph.get(qu.poll())) {
                    inDegrees[next]--;
                    if (inDegrees[next] == 0) {
                        qu.offer(next);
                    }
                }
            }
            return true;
        }
    }
}