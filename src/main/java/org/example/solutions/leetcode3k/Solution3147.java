package org.example.solutions.leetcode3k;

public class Solution3147 {
    class Solution {
        public int maximumEnergy(int[] energy, int k) {
            Integer[] memo = new Integer[energy.length];
            int ans = Integer.MIN_VALUE;
            for (int i = 0; i < energy.length; i++) {
                ans = Math.max(ans, dfs(energy, i, k, memo));
            }
            return ans;
        }

        private int dfs(int[] energy, int i, int k, Integer[] memo) {
            if (memo[i] != null) {
                return memo[i];
            }
            int ans = energy[i];
            int j = i + k;
            if (j >= 0 && j < energy.length) {
                ans += dfs(energy, j, k, memo);
            }
            return memo[i] = ans;
        }
    }
}