package org.example.solutions.leetcode200to1k;

import java.util.*;

public class Solution912 {
    class Solution {
        Random random = new Random();

        public int[] sortArray(int[] nums) {
            qsort(nums, 0, nums.length - 1);
            return nums;
        }

        private void qsort(int[] nums, int l, int r) {
            if (l < r) {
                int pos = randomizedPartition(nums, l, r);
                qsort(nums, l, pos - 1);
                qsort(nums, pos + 1, r);
            }
        }

        private static int partition(int[] nums, int l, int r) {
            int pivot = nums[r];
            int i = l - 1;
            for (int j = l; j <= r - 1; j++) {
                if (nums[j] <= pivot) {
                    i++;
                    swap(nums, i, j);
                }
            }
            swap(nums, i + 1, r);
            return i + 1;
        }

        private int randomizedPartition(int[] nums, int l, int r) {
            int i = random.nextInt(r - l + 1) + l;
            swap(nums, r, i);
            return partition(nums, l, r);
        }

        private static void swap(int[] nums, int i, int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
}