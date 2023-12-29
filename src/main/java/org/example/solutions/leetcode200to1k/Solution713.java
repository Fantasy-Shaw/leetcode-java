package org.example.solutions.leetcode200to1k;

import java.util.*;

public class Solution713 {
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int n = nums.length, ans = 0;
            int t = 1, j = 0;
            for (int i = 0; i < n; i++) {
                t *= nums[i];
                while (j <= i && t >= k) {
                    t /= nums[j];
                    j++;
                }
                ans += (i - j + 1);
            }
            return ans;
        }
    }
}