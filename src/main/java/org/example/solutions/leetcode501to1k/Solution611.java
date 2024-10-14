package org.example.solutions.leetcode501to1k;

import java.util.Arrays;

public class Solution611 {
    class Solution {
        public int triangleNumber(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            int ans = 0;
            for (int i = 2; i < n; i++) {
                int l = 0, r = i - 1;
                while (l < r) {
                    if (nums[l] + nums[r] > nums[i]) {
                        ans += (r - l);
                        r--;
                    } else {
                        l++;
                    }
                }
            }
            return ans;
        }
    }
}