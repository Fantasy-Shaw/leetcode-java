package org.example.solutions.leetcode1kto2k;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution1584 {
    class UnionFind {
        private int count;
        private int[] parent;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            parent[rootA] = rootB;
            count--; // 连通分量数量
        }

        public boolean isConnected(int a, int b) {
            return find(a) == find(b);
        }

        public int getCount() {
            return count;
        }
    }

    class Solution {
        public int minCostConnectPoints(int[][] points) {
            int n = points.length;
            List<int[]> edges = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int x1 = points[i][0], y1 = points[i][1];
                    int x2 = points[j][0], y2 = points[j][1];
                    int cost = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                    edges.add(new int[]{i, j, cost});
                }
            }
            edges.sort(Comparator.comparingInt(value -> value[2]));
            UnionFind uf = new UnionFind(n);
            int ans = 0;
            for (var edge : edges) {
                int i = edge[0], j = edge[1], cost = edge[2];
                if (uf.isConnected(i, j)) {
                    continue;
                }
                uf.union(i, j);
                ans += cost;
            }
            return ans;
        }
    }
}