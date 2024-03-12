package org.example.templates;

public
class Fenwick {
    private final int[] tree;

    public Fenwick(int n) {
        this.tree = new int[n];
    }

    public void add(int i, int u) {
        // i >= 1
        while (i < tree.length) {
            tree[i] += u;
            i += i & -i;
        }
    }

    public int pre(int i) {
        int res = 0;
        while (i > 0) {
            res += tree[i];
            i &= i - 1; // i -= i & -i
        }
        return res;
    }
}