package org.example.solutions.leetcode3k;

import java.util.Arrays;

public class Solution3108 {
    class Solution {
        public int[] minimumCost(int n, int[][] edges, int[][] query) {
            UnionFindAnd uf = new UnionFindAnd(n);
            for (var e : edges) {
                uf.union(e[0], e[1], e[2]);
            }
            int[] ans = new int[query.length];
            for (int i = 0; i < query.length; i++) {
                int x = query[i][0], y = query[i][1];
                ans[i] = (x == y) ? 0 : uf.isConnected(x, y) ? uf.and[uf.find(x)] : -1;
            }
            return ans;
        }
    }

    class UnionFindAnd {
        private int count;
        private int[] parent;
        public int[] and;

        public UnionFindAnd(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            and = new int[n];
            Arrays.fill(and, -1);
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
            and[rootB] &= w;
            if (rootA == rootB) {
                return false; // 已经处于同一个连通分量
            } else {
                count--; // 连通分量数量
                parent[rootA] = rootB;
                and[rootB] &= and[rootA];
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