package org.example.solutions.leetcode501to1k;

import java.util.*;

public class Solution681 {
    class Solution {
        public String nextClosestTime(String time) {
            int[] nums = new int[4];
            int mn = Integer.MAX_VALUE;
            int idx = 0;
            for (int i = 0; i < time.length(); i++) {
                char ch = time.charAt(i);
                if (Character.isDigit(ch)) {
                    int n = ch - '0';
                    mn = Math.min(mn, n);
                    nums[idx++] = n;
                }

            }
            boolean isToday = false;
            for (int i = nums.length - 1; i >= 0; i--) {
                int mnLarger = Integer.MAX_VALUE;
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] > nums[i]) {
                        mnLarger = Math.min(mnLarger, nums[j]);
                    }
                }
                if (mnLarger != Integer.MAX_VALUE) {
                    int t = nums[i];
                    nums[i] = mnLarger;
                    if (isValid(nums)) {
                        for (int j = i + 1; j < nums.length; j++) {
                            nums[j] = mn;
                        }
                        isToday = true;
                        break;
                    } else {
                        nums[i] = t;
                    }
                }
            }
            if (!isToday) {
                Arrays.fill(nums, mn);
            }
            return String.valueOf(nums[0]) + nums[1] + ':' + nums[2] + nums[3];
        }

        boolean isValid(int[] nums) {
            return nums[0] <= 2 && (nums[0] != 2 || nums[1] <= 3) && nums[2] <= 5;
        }
    }
}