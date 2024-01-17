package org.example.solutions.leetcode200to1k;

public class Solution287 {
    class Solution {
        int[] nums;

        public int findDuplicate(int[] nums) {
            // hash: nums[idx] = idx + 1 -> nums[t - 1] = t
            this.nums = nums;
            for (int i = 0; i < nums.length; ) {
                int t = nums[i], idx = t - 1;
                if (nums[idx] == t) {
                    if (idx != i) { // conflict
                        return t;
                    }
                    i++;
                } else {
                    swapNums(idx, i);
                }
            }
            return -1;
        }

        private void swapNums(int i, int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
}