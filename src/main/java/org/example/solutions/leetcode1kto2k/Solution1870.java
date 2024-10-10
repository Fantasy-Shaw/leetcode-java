package org.example.solutions.leetcode1kto2k;

public class Solution1870 {
    static
    class Solution {
        public int minSpeedOnTime(int[] dist, double hour) {
            int l = (int) -1e7, r = 0;
            if (!isValid(dist, hour, -l)) {
                return -1;
            }
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (isValid(dist, hour, -mid)) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return -(l - 1);
        }

        private boolean isValid(int[] dist, double hour, int v) {
            double time = 0;
            for (int i = 0; i < dist.length - 1; i++) {
                time += Math.ceilDiv(dist[i], v);
            }
            time += (double) dist[dist.length - 1] / v;
            return time < hour || Math.abs(time - hour) < 1e-9;
        }
    }
}