package org.example.solutions.leetcode201to500;

import java.util.Random;

public class Solution215 {
    class Solution {
        private static final Random random = new Random(System.currentTimeMillis());

        public int findKthLargest(int[] nums, int k) {
            int n = nums.length;
            int target = n - k;
            int l = 0, r = n - 1;
            while (l <= r) {
                int idx = partition(nums, l, r);
                if (idx == target) {
                    return nums[idx];
                } else if (idx < target) {
                    l = idx + 1;
                } else {
                    r = idx - 1;
                }
            }
            return Integer.MIN_VALUE;
        }

        private int partition(int[] nums, int l, int r) {
            int randomIdx = l + random.nextInt(r - l + 1);
            swap(nums, l, randomIdx);
            int i = l - 1;
            for (int j = l; j < r; j++) {
                if (nums[j] <= nums[r]) {
                    swap(nums, ++i, j);
                }
            }
            swap(nums, i + 1, r);
            return i + 1;
        }

        private void swap(int[] nums, int i, int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
}