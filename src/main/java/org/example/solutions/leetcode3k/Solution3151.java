package org.example.solutions.leetcode3k;

public class Solution3151 {
    class Solution {
        public boolean isArraySpecial(int[] nums) {
            int flag = nums[0] % 2 == 0 ? 1 : -1;
            for (int i = 1; i < nums.length; i++) {
                int cur = nums[i] % 2 == 0 ? 1 : -1;
                if (flag * cur == 1) {
                    return false;
                }
                flag = cur;
            }
            return true;
        }
    }
}