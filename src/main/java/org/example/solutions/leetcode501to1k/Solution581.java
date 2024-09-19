package org.example.solutions.leetcode501to1k;

import java.util.Arrays;

public class Solution581 {
    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            int[] x = nums.clone();
            Arrays.sort(x);
            int i = 0;
            for (; i < nums.length; i++) {
                if (nums[i] != x[i]) {
                    break;
                }
            }
            if (i == nums.length) return 0;
            int l = i, r = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] != x[j]) {
                    r = Math.max(r, j);
                }
            }
            return r - l + 1;
        }
    }
}