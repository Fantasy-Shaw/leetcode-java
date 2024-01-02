package org.example.templates;

/**
 * 线段树，维护区间和
 */
public class SegNodeForRangeSum {
    public SegNodeForRangeSum ls, rs;
    public int val = 0;

    public static void update(SegNodeForRangeSum node, long lc, long rc, long x, int v) {
        node.val += v;
        long mid = (lc + rc) >> 1;
        if (lc >= rc) return;
        if (x <= mid) {
            if (node.ls == null) node.ls = new SegNodeForRangeSum();
            update(node.ls, lc, mid, x, v);
        } else {
            if (node.rs == null) node.rs = new SegNodeForRangeSum();
            update(node.rs, mid + 1, rc, x, v);
        }
    }

    public static int query(SegNodeForRangeSum node, long lc, long rc, long l, long r) {
        if (node == null) return 0;
        if (r < lc || l > rc) return 0;
        if (l <= lc && rc <= r) return node.val;
        long mid = (lc + rc) >> 1;
        return query(node.ls, lc, mid, l, r) + query(node.rs, mid + 1, rc, l, r);
    }
}
