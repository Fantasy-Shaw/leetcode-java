package org.example.solutions.leetcode501to1k;

public class Solution540 {
    class Solution {
        public int singleNonDuplicate(int[] nums) {
            int n = nums.length;
            int l = 0, r = n;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (mid % 2 == 0) {
                    if (mid + 1 < n && nums[mid] == nums[mid + 1]) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                } else {
                    if (mid - 1 >= 0 && nums[mid - 1] == nums[mid]) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
            }
            return nums[l];
        }
    }
}