package org.example.solutions.leetcode501to1k;

import java.util.Arrays;

public class Solution826 {
    class Solution {
        public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
            int n = difficulty.length;
            int[][] diffPrf = new int[n][2];
            for (int i = 0; i < n; i++) {
                diffPrf[i][0] = difficulty[i];
                diffPrf[i][1] = profit[i];
            }
            Arrays.sort(diffPrf, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
            int[] mxProfit = new int[n];
            mxProfit[0] = diffPrf[0][1];
            for (int i = 1; i < n; i++) {
                mxProfit[i] = Math.max(mxProfit[i - 1], diffPrf[i][1]);
            }
            int ans = 0;
            for (int w : worker) {
                int idx = upperBound(diffPrf, w) - 1;
                if (idx >= 0) {
                    ans += mxProfit[idx];
                }
            }
            return ans;
        }

        public static int upperBound(int[][] diffPrf, int target) {
            int l = 0, r = diffPrf.length;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (diffPrf[mid][0] <= target) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l;
        }
    }
}