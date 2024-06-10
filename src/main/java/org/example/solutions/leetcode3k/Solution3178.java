package org.example.solutions.leetcode3k;

public class Solution3178 {
    class Solution {
        public int valueAfterKSeconds(int n, int k) {
            int[] nums = new int[n];
            int[] nums2 = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = i + 1;
            }
            for (int t = 0; t < k - 1; t++) {
                int s = 0;
                for (int i = 0; i < n; i++) {
                    nums2[i] = (nums[i] + s) % 1_000_000_007;
                    s = (s + nums[i]) % 1_000_000_007;
                }
                // Swap nums and nums2
                int[] temp = nums;
                nums = nums2;
                nums2 = temp;
            }
            return nums[n - 1];
        }
    }
}