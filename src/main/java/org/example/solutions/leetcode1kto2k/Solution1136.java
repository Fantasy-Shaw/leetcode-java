package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1136 {
    class Solution {
        public int minimumSemesters(int n, int[][] relations) {
            int[] inDegrees = new int[n + 1];
            List<Set<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new HashSet<>());
            }
            // relations[i] = [prevCourse{i}, nextCourse{i}]
            for (var r : relations) {
                if (graph.get(r[0]).add(r[1])) {
                    inDegrees[r[1]]++;
                }
            }
            Queue<Integer> qu = new ArrayDeque<>();
            for (int i = 1; i <= n; i++) {
                if (inDegrees[i] == 0) {
                    qu.offer(i);
                }
            }
            if (qu.isEmpty()) {
                return -1;
            }
            int reservedNodes = n, minimumTerms = 0;
            while (!qu.isEmpty()) {
                int cur = qu.size();
                reservedNodes -= cur;
                minimumTerms++;
                for (int i = 0; i < cur; i++) { //只取这个学期的
                    for (int next : graph.get(qu.poll())) {
                        inDegrees[next]--;
                        if (inDegrees[next] == 0) {
                            qu.offer(next);
                        }
                    }
                }
            }
            return reservedNodes > 0 ? -1 : minimumTerms;
        }
    }
}