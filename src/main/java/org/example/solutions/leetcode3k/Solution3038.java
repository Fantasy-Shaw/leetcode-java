package org.example.solutions.leetcode3k;

public class Solution3038 {
    class Solution {
        public int maxOperations(int[] nums) {
            int ans = 1;
            int pre = nums[0] + nums[1];
            for (int i = 3; i < nums.length; i += 2) {
                int cur = nums[i - 1] + nums[i];
                if (cur == pre) {
                    ans++;
                } else {
                    break;
                }
            }
            return ans;
        }
    }
}