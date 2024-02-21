package org.example.solutions.leetcode1to200;

public class Solution31 {
    class Solution {
        public void nextPermutation(int[] nums) {
            int i = nums.length - 2;
            while (i >= 0 && nums[i] >= nums[i + 1]) {
                i--;
            }
            if (i >= 0) {
                int j = nums.length - 1;
                while (j >= 0 && nums[i] >= nums[j]) {
                    j--;
                }
                swap(nums, i, j);
            }
            reverse(nums, i + 1, nums.length);
        }

        static void swap(int[] nums, int x, int y) {
            var t = nums[x];
            nums[x] = nums[y];
            nums[y] = t;
        }

        static void reverse(int[] nums, int l, int r) {
            int n = r - l;
            for (int i = 0; i < n / 2; i++) {
                var t = nums[l + i];
                nums[l + i] = nums[r - i - 1];
                nums[r - i - 1] = t;
            }
        }
    }
}