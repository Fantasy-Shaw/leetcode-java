package org.example.solutions.leetcode3k;

import java.util.Arrays;

public class Solution3180 {
    class Solution {
        public int maxTotalReward(int[] rewardValues) {
            int n = rewardValues.length;
            int[][] memo = new int[n][2001];
            for (var it : memo) {
                Arrays.fill(it, -1);
            }
            Arrays.sort(rewardValues);
            return dfs(rewardValues, 0, 0, memo);
        }

        private int dfs(int[] nums, int i, int sum, int[][] memo) {
            if (i >= nums.length || sum > 2000) {
                return 0;
            }
            if (memo[i][sum] != -1) {
                return memo[i][sum];
            }
            int j1 = upper_bound(nums, nums[i]);
            int j2 = upper_bound(nums, sum + nums[i]);
            return memo[i][sum] = Math.max(
                    dfs(nums, j1, sum, memo),
                    nums[i] + dfs(nums, j2, sum + nums[i], memo)
            );
        }

        private static int upper_bound(int[] nums, int target) {
            int l = 0, r = nums.length;
            while (l < r) {
                int mid = (l + r) / 2;
                if (nums[mid] <= target) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l;
        }
    }
}