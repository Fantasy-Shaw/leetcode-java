package org.example.solutions.leetcode1kto2k;

import org.example.templates.MultiSet;

public class Solution1438 {
    class Solution {
        public int longestSubarray(int[] nums, int limit) {
            int n = nums.length;
            MultiSet<Integer> mset = new MultiSet<>();
            int ans = 0;
            for (int i = 0, j = 0; i < n && j < n; j++) {
                mset.add(nums[j]);
                while (i < j && !mset.isEmpty() && mset.peekLast() - mset.peekFirst() > limit) {
                    mset.remove(nums[i]);
                    i++;
                }
                ans = Math.max(ans, j - i + 1);
            }
            return ans;
        }
    }
}