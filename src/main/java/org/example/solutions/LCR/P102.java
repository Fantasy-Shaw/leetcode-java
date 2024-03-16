package org.example.solutions.LCR;

import java.util.*;

public class P102 {
    class Solution {
        /**
         * nums with "+" : s, all the nums : sum
         * s-(sum-s) = target -> s = (sum+target)/2
         */
        public int findTargetSumWays(int[] nums, int target) {
            int s = Arrays.stream(nums).sum() + target;
            if (s < 0 || s % 2 == 1) {
                return 0;
            }
            s /= 2;
            int[][] memo = new int[nums.length][s + 1];
            for (var it : memo) {
                Arrays.fill(it, -1);
            }
            return dfs(nums, 0, 0, s, memo);
        }

        private int dfs(int[] nums, int i, int sum, int target, int[][] memo) {
            if (i >= nums.length) {
                return sum == target ? 1 : 0;
            }
            if (sum > target) {
                return 0;
            }
            if (memo[i][sum] != -1) {
                return memo[i][sum];
            }
            int ans = dfs(nums, i + 1, sum + nums[i], target, memo) + dfs(nums, i + 1, sum, target, memo);
            memo[i][sum] = ans;
            return ans;
        }
    }
}