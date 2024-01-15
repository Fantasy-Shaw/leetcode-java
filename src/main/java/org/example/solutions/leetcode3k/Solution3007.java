package org.example.solutions.leetcode3k;

import java.util.Arrays;

public class Solution3007 {
    class Solution {
        int x;
        long num;
        long[][] memo;

        public long findMaximumNumber(long k, int x) {
            this.x = x;
            long left = 0, right = (k + 1) << x;
            while (left + 1 < right) {
                long mid = left + (right - left) / 2;
                if (countDigitOne(mid) <= k) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            return left;
        }

        private long countDigitOne(long num) {
            this.num = num;
            int m = 64 - Long.numberOfLeadingZeros(num);
            memo = new long[m][m + 1];
            for (long[] row : memo) {
                Arrays.fill(row, -1);
            }
            return dfs(m - 1, 0, true);
        }

        private long dfs(int i, int cnt1, boolean isLimit) {
            if (i < 0) return cnt1;
            if (!isLimit && memo[i][cnt1] != -1) return memo[i][cnt1];
            int up = isLimit ? (int) (num >> i & 1) : 1;
            long res = 0;
            for (int d = 0; d <= up; d++) {
                res += dfs(i - 1, cnt1 + (d == 1 && (i + 1) % x == 0 ? 1 : 0), isLimit && (d == up));
            }
            if (!isLimit) memo[i][cnt1] = res;
            return res;
        }
    }
}
