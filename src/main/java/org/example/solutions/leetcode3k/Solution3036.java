package org.example.solutions.leetcode3k;

import org.example.templates.StringHash;

public class Solution3036 {
    class Solution {
        public int countMatchingSubarrays(int[] nums, int[] pattern) {
            int n = nums.length - 1;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                if (nums[i + 1] > nums[i]) {
                    arr[i] = 1;
                } else if (nums[i + 1] < nums[i]) {
                    arr[i] = -1;
                } else {
                    arr[i] = 0;
                }
            }
            StringBuilder sbArr = new StringBuilder();
            for (int i : arr) {
                sbArr.append(i + 2);
            }
            StringHash ha = new StringHash(sbArr);
            StringBuilder pt = new StringBuilder();
            for (int i : pattern) {
                pt.append(i + 2);
            }
            long hp = new StringHash(pt).getSubStrHash(0, pt.length());
            int k = pt.length();
            int ans = 0;
            for (int i = 0; i <= n - k; i++) {
                if (ha.getSubStrHash(i, i + k) == hp) {
                    ans++;
                }
            }
            return ans;
        }
    }
}