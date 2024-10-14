package org.example.solutions.leetcode1kto2k;

public class Solution1014 {
    class Solution {
        public int maxScoreSightseeingPair(int[] values) {
            int[] mx = new int[]{values[0], 0};
            int ans = 0;
            for (int i = 1; i < values.length; i++) {
                ans = Math.max(ans, mx[0] + values[i] + mx[1] - i);
                if (values[i] + i > mx[0] + mx[1]) {
                    mx[0] = values[i];
                    mx[1] = i;
                }
            }
            return ans;
        }
    }
}