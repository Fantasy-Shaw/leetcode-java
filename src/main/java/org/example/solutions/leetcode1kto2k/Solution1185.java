package org.example.solutions.leetcode1kto2k;

public class Solution1185 {
    class Solution {
        private static final String[] dayInAWeek = {
                "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
        };
        private static final int[] daysInMonths = {
                0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
        };

        public String dayOfTheWeek(int day, int month, int year) {
            // 1970-12-31 is Thursday
            int ans = 4;
            for (int i = 1971; i < year; i++) {
                ans += isLeap(i) ? 366 : 365;
            }
            for (int i = 1; i < month; i++) {
                ans += daysInMonths[i];
                if (i == 2 && isLeap(year)) ans++;
            }
            ans += day;
            return dayInAWeek[ans % 7];
        }

        private static boolean isLeap(int year) {
            return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        }
    }
}