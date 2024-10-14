package org.example.solutions.leetcode1kto2k;

import java.util.ArrayList;
import java.util.List;

public class Solution1376 {
    class Solution {
        private List<List<Integer>> graph;
        private int[] informTime;

        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
            graph = new ArrayList<>();
            this.informTime = informTime;
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < n; i++) {
                if (manager[i] >= 0) {
                    graph.get(manager[i]).add(i); // build a tree
                }
            }
            return dfs(headID);
        }

        private int dfs(int x) {
            int maxPathLen = 0;
            for (int y : graph.get(x)) {
                maxPathLen = Math.max(maxPathLen, dfs(y));
            }
            return maxPathLen + informTime[x];
        }
    }
}