package org.example.solutions.leetcode201to500;

import java.util.*;

public class Solution209 {
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int n = nums.length;
            int ans = Integer.MAX_VALUE;
            int[] sum = new int[n + 1];
            for (int i = 0; i < n; i++) {
                sum[i + 1] = sum[i] + nums[i];
            }
            for (int i = 0; i < n; i++) {
                int j = lower_bound(sum, i, n + 1, sum[i] + target);
                if (j != n + 1) {
                    ans = Math.min(ans, j - i);
                }
            }
            return ans < Integer.MAX_VALUE ? ans : 0;
        }

        private static int lower_bound(int[] nums, int l, int r, int target) {
            // [l,r)
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l;
        }
    }
}