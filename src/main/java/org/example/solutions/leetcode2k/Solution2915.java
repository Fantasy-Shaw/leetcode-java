package org.example.solutions.leetcode2k;

import java.util.Arrays;
import java.util.List;

public class Solution2915 {
    class Solution {
        public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
            int[] dp = new int[target + 1];
            Arrays.fill(dp, Integer.MIN_VALUE);
            dp[0] = 0;
            for (int x : nums) {
                for (int i = target; i >= x; i--) {
                    dp[i] = Math.max(dp[i], dp[i - x] + 1);
                }
            }
            return dp[target] > 0 ? dp[target] : -1;
        }
    }
}