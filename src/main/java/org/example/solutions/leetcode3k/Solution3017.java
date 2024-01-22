package org.example.solutions.leetcode3k;

public class Solution3017 {
    class Solution {
        long[] diff;

        public long[] countOfPairs(int n, int x, int y) {
            diff = new long[n + 1];
            if (x > y) {
                int t = x;
                x = y;
                y = t;
            }
            for (int i = 1; i <= n; i++) {
                add(1, i - 1, 1);
                add(1, n - i, 1);
                if (x + 1 >= y) {
                    continue;
                }
                if (i <= x) {
                    update(i, x, y, n);
                } else if (i >= y) {
                    update(n + 1 - i, n + 1 - y, n + 1 - x, n);
                } else if (i < (x + y) / 2) {
                    update2(i, x, y, n);
                } else if (i > (x + y + 1) / 2) {
                    update2(n + 1 - i, n + 1 - y, n + 1 - x, n);
                }
            }
            long[] ans = new long[n];
            ans[0] = diff[1];
            for (int i = 1; i < n; i++) {
                ans[i] = ans[i - 1] + diff[i + 1];
            }
            return ans;
        }

        private void add(int l, int r, int v) {
            if (l > r) return;
            diff[l] += v;
            diff[r + 1] -= v;
        }

        private void update(int i, int x, int y, int n) {
            add(y - i, n - i, -1);
            int dec = y - x - 1;
            add(y - i - dec, n - i - dec, 1);
            int j = (x + y + 1) / 2 + 1;
            add(j - i, y - 1 - i, -1);
            add(x - i + 2, x - i + y - j + 1, 1);
        }

        private void update2(int i, int x, int y, int n) {
            add(y - i, n - i, -1);
            int dec = (y - i) - (i - x + 1);
            add(y - i - dec, n - i - dec, 1);
            int j = i + (y - x + 1) / 2 + 1;
            add(j - i, y - 1 - i, -1);
            add(i - x + 2, i - x + y - j + 1, 1);
        }
    }
}