package org.example.solutions.leetcode1kto2k;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution1462 {
    class Solution {
        public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
            int[] inDegrees = new int[numCourses];
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                graph.add(new ArrayList<>());
            }
            // prerequisites[i] = {preCourse[i], nextCourse[i]}
            for (var p : prerequisites) {
                graph.get(p[0]).add(p[1]);
                inDegrees[p[1]]++;
            }
            Queue<Integer> qu = new ArrayDeque<>();
            boolean[][] isPre = new boolean[numCourses][numCourses];
            for (int i = 0; i < numCourses; i++) {
                if (inDegrees[i] == 0) {
                    qu.offer(i);
                }
            }
            while (!qu.isEmpty()) {
                int curSz = qu.size();
                for (int i = 0; i < curSz; i++) { //只取这个学期的
                    int cur = qu.poll();
                    for (int next : graph.get(cur)) {
                        isPre[cur][next] = true;
                        // Floyd变种
                        for (int j = 0; j < numCourses; j++) {
                            isPre[j][next] |= isPre[j][cur];
                        }
                        inDegrees[next]--;
                        if (inDegrees[next] == 0) {
                            qu.offer(next);
                        }
                    }
                }
            }
            List<Boolean> ans = new ArrayList<>();
            for (var q : queries) {
                ans.add(isPre[q[0]][q[1]]);
            }
            return ans;
        }
    }
}