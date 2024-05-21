package org.example.templates.SegTree;

/**
 * 线段树，维护区间内的最大值
 */
public class SegNodeForMaxVal {
    public SegNodeForMaxVal ls, rs;
    public int max = 0, add = 0;

    public static void update(SegNodeForMaxVal node, int lc, int rc, int l, int r, int v) {
        if (l <= lc && rc <= r) {
            node.add = v;
            node.max = v;
            return;
        }
        pushDown(node);
        int mid = (lc + rc) / 2;
        if (l <= mid) update(node.ls, lc, mid, l, r, v);
        if (r > mid) update(node.rs, mid + 1, rc, l, r, v);
        pushUp(node);
    }

    public static int query(SegNodeForMaxVal node, int lc, int rc, int l, int r) {
        if (l <= lc && rc <= r) {
            return node.max;
        }
        pushDown(node);
        int mid = (lc + rc) / 2, ans = 0;
        if (l <= mid) ans = query(node.ls, lc, mid, l, r);
        if (r > mid) ans = Math.max(ans, query(node.rs, mid + 1, rc, l, r));
        return ans;
    }

    private static void pushUp(SegNodeForMaxVal node) {
        node.max = Math.max(node.ls.max, node.rs.max);
    }

    private static void pushDown(SegNodeForMaxVal node) {
        if (node.ls == null) node.ls = new SegNodeForMaxVal();
        if (node.rs == null) node.rs = new SegNodeForMaxVal();
        int add = node.add;
        if (add == 0) return;
        node.ls.max = add;
        node.rs.max = add;
        node.ls.add = add;
        node.rs.add = add;
        node.add = 0;
    }
}