package org.example.solutions.leetcode501to1k;

public class Solution704 {
    class Solution {
        public int search(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            while (l <= r) {
                int mid = (l + r) >> 1;
                if (nums[mid] < target) {
                    l = mid + 1;
                } else if (nums[mid] == target) {
                    return mid;
                } else {
                    r = mid - 1;
                }
            }
            return -1;
        }
    }
}