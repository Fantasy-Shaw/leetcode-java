package org.example.solutions.leetcode2k;

import java.util.*;

public class Solution2646 {
    class Solution {
        private List<List<Integer>> next;
        private int[] count, price;

        public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
            this.price = price;
            count = new int[n];
            next = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                next.add(new ArrayList<>());
            }
            for (var edge : edges) {
                next.get(edge[0]).add(edge[1]);
                next.get(edge[1]).add(edge[0]);
            }
            for (var trip : trips) {
                dfs(trip[0], -1, trip[1]);
            }
            int[] ans = dp(0, -1);
            return Math.min(ans[0], ans[1]);
        }

        private boolean dfs(int node, int parent, int end) {
            if (node == end) {
                count[node]++;
                return true;
            }
            for (int child : next.get(node)) {
                if (child == parent) continue;
                if (dfs(child, node, end)) {
                    count[node]++;
                    return true;
                }
            }
            return false;
        }

        private int[] dp(int node, int parent) {
            int[] res = new int[]{price[node] * count[node], price[node] * count[node] / 2};
            for (var child : next.get(node)) {
                if (child == parent) continue;
                int[] p = dp(child, node);
                res[0] += Math.min(p[0], p[1]);
                res[1] += p[0];
            }
            return res;
        }
    }
}