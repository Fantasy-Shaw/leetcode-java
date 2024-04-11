package org.example.solutions.leetcode201to500;

import java.util.*;

public class Solution399 {
    class Solution {
        private int id;
        private Map<String, Integer> ids;

        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            id = 0;
            ids = new HashMap<>();
            int n = values.length;
            UnionFind uf = new UnionFind(n * 2 + 10);
            for (int i = 0; i < n; i++) {
                uf.union(
                        getWordId(equations.get(i).getFirst()),
                        getWordId(equations.get(i).getLast()),
                        values[i]
                );
            }
            int m = queries.size();
            double[] ans = new double[m];
            for (int i = 0; i < m; i++) {
                String a = queries.get(i).getFirst(), b = queries.get(i).getLast();
                ans[i] = ids.containsKey(a) && ids.containsKey(b) ? uf.isConnected(getWordId(a), getWordId(b)) : -1;
            }
            return ans;
        }

        private int getWordId(String s) {
            return ids.computeIfAbsent(s, k -> id++);
        }

        static class UnionFind {
            private int count;
            private int[] parent;
            private double[] weight;

            public UnionFind(int n) {
                count = n;
                parent = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
                weight = new double[n];
                Arrays.fill(weight, 1.0);
            }

            public int find(int x) {
                if (parent[x] != x) {
                    int t = parent[x];
                    parent[x] = find(parent[x]);
                    weight[x] *= weight[t];
                }
                return parent[x];
            }

            public boolean union(int a, int b, double val) {
                int rootA = find(a);
                int rootB = find(b);
                if (rootA == rootB) {
                    return false; // 已经处于同一个连通分量
                } else {
                    count--; // 连通分量数量
                    parent[rootA] = rootB;
                    weight[rootA] = weight[b] * val / weight[a];
                    return true;
                }
            }

            public double isConnected(int a, int b) {
                int rootA = find(a);
                int rootB = find(b);
                if (rootA == rootB) {
                    return weight[a] / weight[b];
                } else {
                    return -1.0;
                }
            }

            public int getCount() {
                return count;
            }
        }
    }
}