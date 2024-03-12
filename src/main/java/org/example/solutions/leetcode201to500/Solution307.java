package org.example.solutions.leetcode201to500;

import org.example.templates.Fenwick;

public class Solution307 {
    class NumArray {
        Fenwick fw;
        int[] nums;

        public NumArray(int[] nums) {
            int n = nums.length;
            this.nums = nums;
            fw = new Fenwick(n + 1);
            for (int i = 1; i <= n; i++) {
                fw.add(i, nums[i - 1]);
            }
        }

        public void update(int index, int val) {
            fw.add(index + 1, val - nums[index]);
            nums[index] = val;
        }

        public int sumRange(int left, int right) {
            return fw.pre(right + 1) - fw.pre(left);
        }
    }
}