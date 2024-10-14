package org.example.solutions.leetcode501to1k;

import java.util.Arrays;

public class Solution976 {
    class Solution {
        public int largestPerimeter(int[] nums) {
            Arrays.sort(nums);
            int i = nums.length - 1, j = nums.length - 2, k = nums.length - 3;
            while (k >= 0 && !isTriangle(nums[i], nums[j], nums[k])) {
                i--;
                j--;
                k--;
            }
            if (k < 0) return 0;
            return nums[i] + nums[j] + nums[k];
        }

        private static boolean isTriangle(int a, int b, int c) {
            // a>=b>=c
            return b + c > a;
        }
    }
}