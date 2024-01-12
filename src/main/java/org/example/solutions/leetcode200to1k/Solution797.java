package org.example.solutions.leetcode200to1k;

import java.util.*;

public class Solution797 {
    class Solution {
        private List<List<Integer>> ans;
        private List<Integer> temp;
        private int[][] graph;
        private int n;

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            ans = new ArrayList<>();
            temp = new ArrayList<>();
            this.graph = graph;
            n = graph.length;
            temp.add(0);
            dfs(0);
            return ans;
        }

        private void dfs(int u) {
            if (u == n - 1) {
                ans.add(new ArrayList<>(temp));
            }
            for (int next : graph[u]) {
                temp.add(next);
                dfs(next);
                temp.removeLast();
            }
        }
    }
}