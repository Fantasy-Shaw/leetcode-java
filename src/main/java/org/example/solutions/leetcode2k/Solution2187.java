package org.example.solutions.leetcode2k;

import java.util.Arrays;

public class Solution2187 {
    static
    class Solution {
        public long minimumTime(int[] time, int totalTrips) {
            int mn = Arrays.stream(time).max().getAsInt();
            long l = 0, r = (long) totalTrips * mn + 1;
            while (l < r) {
                long mid = l + (r - l) / 2;
                if (!isValid(time, totalTrips, mid)) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l;
        }

        private static boolean isValid(int[] time, long totalTrips, long t) {
            long ans = 0;
            for (int x : time) {
                ans += t / x;
            }
            return ans >= totalTrips;
        }
    }
}