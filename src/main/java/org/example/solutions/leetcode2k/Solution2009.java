package org.example.solutions.leetcode2k;

import java.util.*;

public class Solution2009 {
    class Solution {
        public int minOperations(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            // leetcode-26
            int j = 0;
            for (int i = 1; i < n; i++) {
                if (nums[i] != nums[j]) {
                    nums[++j] = nums[i];
                }
            }
            int m = j + 1;
            int ans = 0, left = 0;
            for (int i = 0; i < m; i++) {
                while (nums[left] <= nums[i] - n) {
                    left++;
                }
                ans = Math.max(ans, i - left + 1);
            }
            return n - ans;
        }
    }
}