package org.example.solutions.leetcode1kto2k;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1042 {
    class Solution {
        public int[] gardenNoAdj(int n, int[][] paths) {
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            for (var e : paths) {
                graph.get(e[0]).add(e[1]);
                graph.get(e[1]).add(e[0]);
            }
            int[] ans1 = new int[n + 1];
            Arrays.fill(ans1, -1);
            boolean[][] vis = new boolean[n + 1][5];
            for (int i = 1; i <= n; i++) {
                if (ans1[i] == -1) {
                    ans1[i] = 1;
                    for (var y : graph.get(i)) {
                        vis[y][1] = true;
                    }
                    dfs(i, ans1, graph, vis);
                }
            }
            int[] ans = new int[n];
            System.arraycopy(ans1, 1, ans, 0, n);
            return ans;
        }

        private void dfs(int x, int[] ans, List<List<Integer>> graph, boolean[][] vis) {
            for (var y : graph.get(x)) {
                if (ans[y] != -1) continue;
                for (int c = 1; c <= 4; c++) {
                    if (!vis[y][c]) {
                        ans[y] = c;
                        for (var z : graph.get(y)) {
                            vis[z][c] = true;
                        }
                        dfs(y, ans, graph, vis);
                        break;
                    }
                }
            }
        }
    }
}