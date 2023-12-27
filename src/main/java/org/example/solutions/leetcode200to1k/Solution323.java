package org.example.solutions.leetcode200to1k;

import java.util.*;

public class Solution323 {
    class UnionFind {
        private int[] parent, size;
        public int n, part;

        public UnionFind(int n) {
            this.n = n;
            this.part = n;
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            this.size = new int[n];
            Arrays.fill(this.size, 1);
        }

        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            return find(parent[x]);
        }

        public boolean union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) {
                return false;
            }
            if (size[rootA] > size[rootB]) {
                int _t = size[rootA];
                size[rootA] = size[rootB];
                size[rootB] = _t;
            }
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
            part--;
            return true;
        }

        public boolean isTheSamePart(int a, int b) {
            return find(a) == find(b);
        }

        public int getPartSize(int a) {
            int rootA = find(a);
            return size[rootA];
        }
    }

    class Solution {
        public int countComponents(int n, int[][] edges) {
            UnionFind uf = new UnionFind(n);
            for (var edge : edges) {
                uf.union(edge[0], edge[1]);
            }
            return uf.part;
        }
    }
}