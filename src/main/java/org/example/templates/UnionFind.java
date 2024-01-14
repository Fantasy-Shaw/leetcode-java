package org.example.templates;

public class UnionFind {
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

    public boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            return false; // 已经处于同一个连通分量
        } else {
            count--; // 连通分量数量
            parent[rootA] = rootB;
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