package org.example.solutions.leetcode1kto2k;

import java.util.ArrayList;
import java.util.List;

public class Solution1466 {
    class Solution {
        // int[2] (v,flag), flag = 0,1 means u->v and v->u, respectively
        List<List<int[]>> graph;
        boolean[] vis;
        int cnt;

        public int minReorder(int n, int[][] connections) {
            graph = new ArrayList<>();
            cnt = 0;
            vis = new boolean[n];
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int[] conn : connections) {
                int u = conn[0], v = conn[1];
                graph.get(u).add(new int[]{v, 0});
                graph.get(v).add(new int[]{u, 1});
            }
            dfs(0);
            return cnt;
        }

        private void dfs(int city) {
            if (vis[city]) {
                return;
            }
            vis[city] = true;
            for (int[] p : graph.get(city)) {
                int v = p[0], flag = p[1];
                if (!vis[v]) {
                    if (flag == 0) cnt++;
                    dfs(v);
                }
            }
        }
    }
}