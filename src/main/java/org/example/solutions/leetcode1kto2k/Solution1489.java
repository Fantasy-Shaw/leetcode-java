package org.example.solutions.leetcode1kto2k;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution1489 {
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
        public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
            int m = edges.length;
            int[][] edgesExtendsIdx = new int[m][4];
            for (int i = 0; i < m; i++) {
                System.arraycopy(edges[i], 0, edgesExtendsIdx[i], 0, 3);
                edgesExtendsIdx[i][3] = i;
            }
            Arrays.sort(edgesExtendsIdx, Comparator.comparingInt(value -> value[2]));
            UnionFind uf = new UnionFind(n);
            int minCost = 0;
            for (int i = 0; i < m; i++) {
                int x = edgesExtendsIdx[i][0], y = edgesExtendsIdx[i][1];
                if (uf.isConnected(x, y)) {
                    continue;
                }
                uf.union(x, y);
                minCost += edgesExtendsIdx[i][2];
            }
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                ans.add(new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                // isCritical
                UnionFind uf1 = new UnionFind(n);
                int v1 = 0;
                for (int j = 0; j < m; j++) {
                    if (i != j) {
                        int x = edgesExtendsIdx[j][0], y = edgesExtendsIdx[j][1];
                        if (!uf1.isConnected(x, y)) {
                            uf1.union(x, y);
                            v1 += edgesExtendsIdx[j][2];
                        }
                    }
                }
                if (uf1.getCount() != 1 || v1 > minCost) {
                    ans.getFirst().add(edgesExtendsIdx[i][3]);
                    continue; //关键边也满足伪关键边对应的性质
                }
                // isPseudoCritical
                UnionFind uf2 = new UnionFind(n);
                uf2.union(
                        edgesExtendsIdx[i][0], edgesExtendsIdx[i][1]
                );
                int v2 = edgesExtendsIdx[i][2];
                for (int j = 0; j < m; j++) {
                    if (i != j) {
                        int x = edgesExtendsIdx[j][0], y = edgesExtendsIdx[j][1];
                        if (!uf2.isConnected(x, y)) {
                            uf2.union(x, y);
                            v2 += edgesExtendsIdx[j][2];
                        }
                    }
                }
                if (v2 == minCost) {
                    ans.getLast().add(edgesExtendsIdx[i][3]);
                }
            }
            return ans;
        }
    }
}