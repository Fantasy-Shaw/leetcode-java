package org.example.solutions.leetcode201to500;

import java.util.Random;

public class Solution384 {
    class Solution {
        final Random random;
        int[] nums;

        public Solution(int[] nums) {
            random = new Random();
            this.nums = nums;
        }

        public int[] reset() {
            return nums;
        }

        public int[] shuffle() {
            int[] ans = nums.clone();
            int n = ans.length;
            for (int i = 0; i < n; i++) {
                int j = random.nextInt(n - i);
                // swap
                int t = ans[n - i - 1];
                ans[n - i - 1] = ans[j];
                ans[j] = t;
            }
            return ans;
        }
    }
}