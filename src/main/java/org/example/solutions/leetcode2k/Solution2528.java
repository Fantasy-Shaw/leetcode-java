package org.example.solutions.leetcode2k;

public class Solution2528 {
    private class Solution {
        public long maxPower(int[] stations, int r, int k) {
            int n = stations.length;
            //prefix
            long[] sum = new long[n + 1];
            for (int i = 0; i < n; i++) {
                sum[i + 1] = sum[i] + stations[i];
            }
            long mn = Long.MAX_VALUE;
            long[] power = new long[n];
            for (int i = 0; i < n; i++) {
                power[i] = sum[Math.min(i + r + 1, n)] - sum[Math.max(i - r, 0)];
                mn = Math.min(mn, power[i]);
            }
            long left = mn, right = mn + k + 1;
            while (left + 1 < right) {
                long mid = left + (right - left) / 2;
                if (check(mid, power, n, r, k)) left = mid;
                else right = mid;
            }
            return left;
        }

        private boolean check(long minPower, long[] power, int n, int r, int k) {
            long[] diff = new long[n + 1];
            long sumD = 0, need = 0;
            for (int i = 0; i < n; i++) {
                sumD += diff[i];
                long m = minPower - power[i] - sumD;
                if (m > 0) {
                    need += m;
                    if (need > k) {
                        return false;
                    }
                    sumD += m;
                    if (i + r * 2 + 1 < n) {
                        diff[i + r * 2 + 1] -= m;
                    }
                }
            }
            return true;
        }
    }
}