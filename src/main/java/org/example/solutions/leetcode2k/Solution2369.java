package org.example.solutions.leetcode2k;

public class Solution2369 {
    class Solution {
        public boolean validPartition(int[] nums) {
            Boolean[] memo = new Boolean[nums.length];
            return dfs(nums, memo, 0);
        }

        private boolean dfs(int[] nums, Boolean[] memo, int i) {
            if (i >= nums.length) {
                return true;
            }
            if (memo[i] != null) {
                return memo[i];
            }
            boolean a = i + 1 < nums.length && nums[i] == nums[i + 1];
            boolean b = i + 2 < nums.length && nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2];
            boolean c = i + 2 < nums.length && nums[i] + 1 == nums[i + 1] && nums[i + 1] + 1 == nums[i + 2];
            boolean ans = (a && dfs(nums, memo, i + 2)) || ((b || c) && dfs(nums, memo, i + 3));
            memo[i] = ans;
            return ans;
        }
    }
}