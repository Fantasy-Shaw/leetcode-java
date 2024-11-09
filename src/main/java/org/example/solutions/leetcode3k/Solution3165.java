package org.example.solutions.leetcode3k;

public class Solution3165 {
    /**
     * Seg tree, w/o updates for intervals
     */
    static
    class Solution {
        private static void maintain(long[][][] f, int o) {
            var a = f[o << 1];
            var b = f[(o << 1) + 1];
            f[o][0][0] = Math.max(a[0][0] + b[1][0], a[0][1] + b[0][0]);
            f[o][0][1] = Math.max(a[0][0] + b[1][1], a[0][1] + b[0][1]);
            f[o][1][0] = Math.max(a[1][0] + b[1][0], a[1][1] + b[0][0]);
            f[o][1][1] = Math.max(a[1][0] + b[1][1], a[1][1] + b[0][1]);
        }

        private static void build(long[][][] f, int[] nums, int o, int l, int r) {
            if (l == r) {
                f[o][1][1] = Math.max(0, nums[l]);
                return;
            }
            int mid = l + (r - l) / 2;
            build(f, nums, o << 1, l, mid);
            build(f, nums, (o << 1) + 1, mid + 1, r);
            maintain(f, o);
        }

        private static void update(long[][][] f, int[] q, int o, int l, int r) {
            if (l == r) {
                f[o][1][1] = Math.max(0, q[1]);
                return;
            }
            int mid = l + (r - l) / 2;
            if (q[0] <= mid) {
                update(f, q, o << 1, l, mid);
            } else {
                update(f, q, (o << 1) + 1, mid + 1, r);
            }
            maintain(f, o);
        }

        public int maximumSumSubsequence(int[] nums, int[][] queries) {
            int n = nums.length;
            long[][][] f = new long[4 * n + 5][2][2];
            build(f, nums, 1, 0, n - 1);
            long ans = 0;
            for (var q : queries) {
                update(f, q, 1, 0, n - 1);
                ans += f[1][1][1];
                ans %= 1_000_000_007;
            }
            return (int) ans;
        }
    }
}