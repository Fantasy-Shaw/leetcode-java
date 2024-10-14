package org.example.solutions.leetcode2k;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2065 {
    class Solution {
        int ans;
        List<int[]>[] graph;
        int[] values;
        int maxTime;

        public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
            this.values = values;
            this.maxTime = maxTime;
            ans = 0;
            int n = values.length;
            graph = new List[n];
            Arrays.setAll(graph, k -> new ArrayList<>());
            for (var e : edges) {
                graph[e[0]].add(new int[]{e[1], e[2]});
                graph[e[1]].add(new int[]{e[0], e[2]});
            }
            int[] vis = new int[n];
            vis[0] = 1;
            dfs(vis, 0, 0, values[0]);
            return ans;
        }

        private void dfs(int[] vis, int x, int time, int val) {
            if (time > maxTime) {
                return;
            }
            if (x == 0) {
                ans = Math.max(ans, val);
            }
            for (var e : graph[x]) {
                int y = e[0], w = e[1];
                vis[y]++;
                dfs(vis, y, time + w, val + (vis[y] == 1 ? values[y] : 0));
                vis[y]--;
            }
        }
    }
}