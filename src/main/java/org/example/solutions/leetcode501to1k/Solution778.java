package org.example.solutions.leetcode501to1k;

import java.util.*;

public class Solution778 {
    class Solution {
        int n;

        public int swimInWater(int[][] grid) {
            n = grid.length;
            if (n == 1) {
                return 0;
            }
            // int[3] : a, b, w
            List<int[]> edges = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    edges.add(new int[]{getId(i, j - 1), getId(i, j), Math.max(grid[i][j], grid[i][j - 1])});
                }
            }
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    edges.add(new int[]{getId(i - 1, j), getId(i, j), Math.max(grid[i - 1][j], grid[i][j])});
                }
            }
            edges.sort(Comparator.comparingInt(a -> a[2]));
            int start = 0, end = n * n - 1;
            UnionFind uf = new UnionFind(n * n);
            for (var e : edges) {
                uf.union(e[0], e[1], e[2]);
                if (uf.isConnected(start, end)) {
                    break;
                }
            }
            return uf.cost[uf.find(start)];
        }

        private int getId(int i, int j) {
            return i * n + j;
        }
    }

    class UnionFind {
        private int count;
        private int[] parent;
        public int[] cost;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            cost = new int[n];
            Arrays.fill(cost, -1);
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int a, int b, int w) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) {
                return false; // 已经处于同一个连通分量
            } else {
                count--; // 连通分量数量
                parent[rootA] = rootB;
                cost[rootA] = Math.max(cost[rootA], w);
                cost[rootB] = Math.max(cost[rootB], w);
                return true;
            }
        }

        public boolean isConnected(int a, int b) {
            return find(a) == find(b);
        }

        public int getCount() {
            return count;
        }
    }
}