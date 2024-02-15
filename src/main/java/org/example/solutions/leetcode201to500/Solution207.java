package org.example.solutions.leetcode201to500;

import java.util.*;

public class Solution207 {
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int[] degrees = new int[numCourses];
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                graph.add(new ArrayList<>());
            }
            for (int[] p : prerequisites) {
                graph.get(p[1]).add(p[0]);
                degrees[p[0]]++;
            }
            List<Integer> ans = new ArrayList<>(numCourses);
            Queue<Integer> qu = new ArrayDeque<>();
            for (int i = 0; i < numCourses; i++) {
                if (degrees[i] == 0) {
                    qu.offer(i);
                }
            }
            while (!qu.isEmpty()) {
                int x = qu.poll();
                ans.add(x);
                for (int y : graph.get(x)) {
                    if (--degrees[y] == 0) {
                        qu.offer(y);
                    }
                }
            }
            return ans.size() == numCourses;
        }
    }
}