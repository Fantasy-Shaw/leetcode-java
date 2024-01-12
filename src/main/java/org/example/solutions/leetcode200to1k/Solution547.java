package org.example.solutions.leetcode200to1k;

public class Solution547 {
    class Solution {
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