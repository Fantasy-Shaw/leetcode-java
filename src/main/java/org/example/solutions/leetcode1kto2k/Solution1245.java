package org.example.solutions.leetcode1kto2k;

import java.util.ArrayList;
import java.util.List;

public class Solution1245 {
    class Solution {
        // dfs for tree
        private int res = 0;

        public int treeDiameter(int[][] edges) {
            List<List<Integer>> map = new ArrayList<>(edges.length + 10);
            boolean[] vis = new boolean[edges.length + 1];
            for (int i = 0; i < edges.length + 1; i++) {
                map.add(new ArrayList<>());
            }
            for (var edge : edges) {
                map.get(edge[0]).add(edge[1]);
                map.get(edge[1]).add(edge[0]);
            }
            dfs(map, 0, vis);
            return res;
        }

        private int dfs(List<List<Integer>> map, int idx, boolean[] vis) {
            vis[idx] = true;
            List<Integer> list = map.get(idx);
            int mx = 0, mx_2nd = 0;
            for (int next : list) {
                if (!vis[next]) {
                    int num = dfs(map, next, vis);
                    if (num > mx) {
                        mx_2nd = mx;
                        mx = num;
                    } else if (num > mx_2nd) {
                        mx_2nd = num;
                    }
                }
            }
            res = Math.max(res, mx + mx_2nd);
            return mx + 1;
        }
    }
}