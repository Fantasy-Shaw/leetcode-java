package org.example.solutions.leetcode3k;

import java.util.Arrays;

public class Solution3040 {
    class Solution {
        public int maxOperations(int[] nums) {
            if (nums.length == 2) {
                return 1;
            }
            int n = nums.length;
            int[][] memo1 = new int[n + 1][n + 1], memo2 = new int[n + 1][n + 1], memo3 = new int[n + 1][n + 1];
            init(memo1);
            init(memo2);
            init(memo3);
            int sum1 = nums[0] + nums[1];
            int sum2 = nums[n - 1] + nums[n - 2];
            int sum3 = nums[n - 1] + nums[0];
            int a = 1 + dfs(nums, 2, n, sum1, memo1);
            int b = 1 + dfs(nums, 0, n - 2, sum2, memo2);
            int c = 1 + dfs(nums, 1, n - 1, sum3, memo3);
            return Math.max(a, Math.max(b, c));
        }

        private int dfs(int[] nums, int l, int r, int sum, int[][] memo) {
            // [l,r)
            if (r - l <= 1) {
                return 0;
            }
            if (memo[l][r] != -1) {
                return memo[l][r];
            }
            int a = 0, b = 0, c = 0;
            if (nums[l] + nums[l + 1] == sum) {
                a = 1 + dfs(nums, l + 2, r, sum, memo);
            }
            if (nums[r - 1] + nums[r - 2] == sum) {
                b = 1 + dfs(nums, l, r - 2, sum, memo);
            }
            if (nums[l] + nums[r - 1] == sum) {
                c = 1 + dfs(nums, l + 1, r - 1, sum, memo);
            }
            memo[l][r] = Math.max(a, Math.max(b, c));
            return memo[l][r];
        }

        private static void init(int[][] memo) {
            for (var it : memo) {
                Arrays.fill(it, -1);
            }
        }
    }
}