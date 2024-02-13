package org.example.solutions.leetcode501to1k;

public class Solution912 {
    class Solution {
        public int[] sortArray(int[] nums) {
            tmp = new int[nums.length];
            mergeSort(nums, 0, nums.length - 1);
            return nums;
        }

        int[] tmp;

        private int mergeSort(int[] record, int l, int r) {
            if (l >= r) {
                return 0;
            }
            int mid = (l + r) / 2;
            int ans = mergeSort(record, l, mid) + mergeSort(record, mid + 1, r);
            int i = l, j = mid + 1;
            for (int k = l; k <= r; k++) {
                tmp[k] = record[k];
            }
            for (int k = l; k <= r; k++) {
                if (i == mid + 1) {
                    record[k] = tmp[j++];
                } else if (j == r + 1 || tmp[i] <= tmp[j]) {
                    record[k] = tmp[i++];
                } else {
                    record[k] = tmp[j++];
                    ans += (mid - i + 1);
                }
            }
            return ans;
        }
    }
}