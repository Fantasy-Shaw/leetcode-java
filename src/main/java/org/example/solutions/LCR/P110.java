package org.example.solutions.LCR;

import java.util.*;

public class P110 {
    class Solution {
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> cur = new ArrayList<>();
            dfs(graph, 0, ans, cur);
            return ans;
        }

        private void dfs(int[][] graph, int i, List<List<Integer>> ans, List<Integer> cur) {
            cur.add(i);
            if (i == graph.length - 1) {
                ans.add(new ArrayList<>(cur));
            }
            for (int u : graph[i]) {
                dfs(graph, u, ans, cur);
            }
            cur.removeLast();
        }
    }
}