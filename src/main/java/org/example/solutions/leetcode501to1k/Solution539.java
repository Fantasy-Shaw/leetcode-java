package org.example.solutions.leetcode501to1k;

import java.util.*;

public class Solution539 {
    class Solution {
        public int findMinDifference(List<String> timePoints) {
            timePoints.sort(String::compareTo);
            int ans = Integer.MAX_VALUE;
            for (int i = 1; i < timePoints.size(); i++) {
                ans = Math.min(ans, deltaMin(timePoints.get(i - 1), timePoints.get(i)));
            }
            // [00:00,...,...,...,23:59]
            ans = Math.min(ans, deltaMin(timePoints.getFirst(), timePoints.getLast()));
            return ans;
        }

        private int deltaMin(String t1, String t2) {
            int m1 = (t1.charAt(0) - '0') * 10 + t1.charAt(1) - '0';
            int s1 = (t1.charAt(3) - '0') * 10 + t1.charAt(4) - '0';
            int m2 = (t2.charAt(0) - '0') * 10 + t2.charAt(1) - '0';
            int s2 = (t2.charAt(3) - '0') * 10 + t2.charAt(4) - '0';
            int ans = (m2 - m1) * 60 + s2 - s1;
            return Math.min(ans, 1440 - ans);
        }
    }
}