package org.example.solutions.leetcode501to1k;

import org.example.templates.UnionFind;

public class Solution547 {
    class Solution {
        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            UnionFind uf = new UnionFind(n);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (isConnected[i][j] == 1) {
                        uf.union(i, j);
                    }
                }
            }
            return uf.getCount();
        }
    }

    class Solution1 {
        private boolean[] vis;
        private int cities;
        private int[][] isConnected;

        public int findCircleNum(int[][] isConnected) {
            cities = isConnected.length;
            vis = new boolean[cities];
            this.isConnected = isConnected;
            int prov = 0;
            for (int i = 0; i < cities; i++) {
                if (!vis[i]) {
                    dfs(i);
                    prov++;
                }
            }
            return prov;
        }

        private void dfs(int i) {
            for (int j = 0; j < cities; j++) {
                if (isConnected[i][j] > 0 && !vis[j]) {
                    vis[j] = true;
                    dfs(j);
                }
            }
        }
    }
}