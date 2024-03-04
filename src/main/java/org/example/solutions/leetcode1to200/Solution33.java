package org.example.solutions.leetcode1to200;

public class Solution33 {
    class Solution {
        public int search(int[] nums, int target) {
            int n = nums.length;
            if (n == 1) {
                return nums[0] == target ? 0 : -1;
            }
            int l = 0, r = n - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[0] <= nums[mid]) { // left is mono
                    if (nums[mid] < target || target < nums[0]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                } else { // right is mono
                    if (nums[mid] < target && target < nums[n - 1]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            }
            return -1;
        }
    }
}