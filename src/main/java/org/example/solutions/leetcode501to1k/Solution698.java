package org.example.solutions.leetcode501to1k;

import java.util.Arrays;

public class Solution698 {
    class Solution {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            Arrays.sort(nums);
            int sum = Arrays.stream(nums).sum();
            int target = sum / k;
            if (sum % k != 0 || nums[nums.length - 1] > target) {
                return false;
            }
            Boolean[] memo = new Boolean[1 << nums.length];
            return dfs(nums, 0, 0, target, memo);
        }

        private boolean dfs(int[] nums, int s, int cur, int target, Boolean[] memo) {
            if (memo[s] != null) return memo[s];
            if (s == (1 << nums.length) - 1) {
                return cur == 0;
            }
            for (int i = 0; i < nums.length; i++) {
                if (((s >> i) & 1) == 0) {
                    if (cur + nums[i] > target) {
                        break;
                    }
                    if (dfs(nums, s | (1 << i), (cur + nums[i]) % target, target, memo)) {
                        return memo[s] = true;
                    }
                }
            }
            return memo[s] = false;
        }
    }
}