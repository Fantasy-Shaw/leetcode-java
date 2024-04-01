package org.example.solutions.leetcode3k;

import java.util.*;

public class Solution3098 {
    class Solution {
        static final int mod = (int) 1e9 + 7;
        static final int inf = Integer.MAX_VALUE / 2;

        public int sumOfPowers(int[] nums, int k) {
            int n = nums.length;
            Arrays.sort(nums);
            return dfs(nums, n - 1, k, inf, inf, new HashMap<>());
        }

        private int dfs(int[] nums, int i, int j, int pre, int minDiff, Map<String, Integer> memo) {
            if (j > i + 1) {
                return 0;
            }
            if (j == 0) {
                return minDiff;
            }
            String key = getKey(i, j, pre, minDiff);
            if (memo.containsKey(key)) {
                return memo.get(key);
            }
            int res1 = dfs(nums, i - 1, j, pre, minDiff, memo);
            int res2 = dfs(nums, i - 1, j - 1, nums[i], Math.min(minDiff, pre - nums[i]), memo);
            int ans = (res1 + res2) % mod;
            memo.put(key, ans);
            return ans;
        }

        private String getKey(int i, int j, int pre, int minDiff) {
            return (i << 16 | j) + " " + ((long) pre << 32 | minDiff);
        }
    }
}