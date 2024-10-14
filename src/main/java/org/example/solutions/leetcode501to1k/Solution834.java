package org.example.solutions.leetcode501to1k;

import java.util.ArrayList;
import java.util.List;

public class Solution834 { // 换根dp
    class Solution {
        public int[] sumOfDistancesInTree(int n, int[][] edges) {
            List<List<Integer>> graph = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            for (var e : edges) {
                graph.get(e[0]).add(e[1]);
                graph.get(e[1]).add(e[0]);
            }
            int[] ans = new int[n];
            int[] size = new int[n]; // size of subtrees
            dfs(graph, 0, -1, 0, ans, size);
            reRoot(graph, 0, -1, n, ans, size);
            return ans;
        }

        private void dfs(List<List<Integer>> graph, int x, int parent, int depth, int[] ans, int[] size) {
            ans[0] += depth;
            size[x] = 1;
            for (int y : graph.get(x)) {
                if (y != parent) {
                    dfs(graph, y, x, depth + 1, ans, size);
                    size[x] += size[y];
                }
            }
        }

        private void reRoot(List<List<Integer>> graph, int x, int parent, int n, int[] ans, int[] size) {
            for (int y : graph.get(x)) {
                if (y != parent) {
                    ans[y] = ans[x] + n - 2 * size[y];
                    reRoot(graph, y, x, n, ans, size);
                }
            }
        }
    }
}