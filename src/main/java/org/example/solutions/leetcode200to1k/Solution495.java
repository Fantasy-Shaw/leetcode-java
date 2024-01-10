package org.example.solutions.leetcode200to1k;

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