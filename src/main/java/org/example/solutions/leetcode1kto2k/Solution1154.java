package org.example.solutions.leetcode1kto2k;

public class Solution1154 {
    class Solution {
        private static final int[] daysInMonths = {
                0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
        };

        public int dayOfYear(String date) {
            String[] ymd = date.split("-");
            int y = Integer.parseInt(ymd[0]), m = Integer.parseInt(ymd[1]), d = Integer.parseInt(ymd[2]);
            int ans = 0;
            if (isLeap(y) && m >= 3) {
                ans++;
            }
            for (int i = 1; i < m; i++) {
                ans += daysInMonths[i];
            }
            ans += d;
            return ans;
        }

        private static boolean isLeap(int year) {
            return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        }
    }
}