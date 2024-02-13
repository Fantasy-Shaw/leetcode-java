package org.example.solutions.leetcode201to500;

public class Solution495 {
    class Solution {
        public int findPoisonedDuration(int[] timeSeries, int duration) {
            int ans = 0;
            for (int i = 1; i < timeSeries.length; i++) {
                ans += Math.min(duration, timeSeries[i] - timeSeries[i - 1]);
            }
            ans += duration;
            return ans;
        }
    }
}