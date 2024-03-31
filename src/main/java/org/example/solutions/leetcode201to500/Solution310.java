package org.example.solutions.leetcode201to500;

import java.util.*;

public class Solution310 {
    class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            for (var e : edges) {
                graph.get(e[0]).add(e[1]);
                graph.get(e[1]).add(e[0]);
            }
            int[] heights0 = new int[n];
            int[] heights = new int[n];
            dfs(graph, heights0, 0);
            reRoot(graph, heights0, heights, 0);
            List<Integer> ans = new ArrayList<>();
            int mn = Arrays.stream(heights).min().getAsInt();
            for (int i = 0; i < n; i++) {
                if (heights[i] == mn) {
                    ans.add(i);
                }
            }
            return ans;
        }

        private void dfs(List<List<Integer>> graph, int[] heights0, int u) {
            heights0[u] = 1;
            int h = 0;
            for (int v : graph.get(u)) {
                if (heights0[v] == 0) {
                    dfs(graph, heights0, v);
                    h = Math.max(h, heights0[v]);
                }
            }
            heights0[u] += h;
        }

        private void reRoot(List<List<Integer>> graph, int[] heights0, int[] heights, int u) {
            int firstMx = 0, secondMx = 0;
            for (int v : graph.get(u)) {
                if (heights0[v] > firstMx) {
                    secondMx = firstMx;
                    firstMx = heights0[v];
                } else if (heights0[v] > secondMx) {
                    secondMx = heights0[v];
                }
            }
            heights[u] = firstMx + 1;
            for (int v : graph.get(u)) {
                if (heights[v] == 0) {
                    heights0[u] = (heights0[v] == firstMx ? secondMx : firstMx) + 1;
                    reRoot(graph, heights0, heights, v);
                }
            }
        }
    }

    class Solution1 {
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