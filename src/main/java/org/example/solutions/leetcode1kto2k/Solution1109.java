package org.example.solutions.leetcode1kto2k;

public class Solution1109 {
    private class Solution {
        public int[] corpFlightBookings(int[][] bookings, int n) {
            int[] ans = new int[n];
            for (int[] b : bookings) {
                ans[b[0] - 1] += b[2];
                if (b[1] < n) {
                    ans[b[1]] -= b[2];
                }
            }
            for (int i = 1; i < n; i++) {
                ans[i] += ans[i - 1];
            }
            return ans;
        }
    }
}