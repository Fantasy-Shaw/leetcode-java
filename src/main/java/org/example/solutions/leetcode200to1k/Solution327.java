package org.example.solutions.leetcode200to1k;

import org.example.templates.SegNodeForRangeSum;

public class Solution327 {
    static class Solution {
        private SegNodeForRangeSum root;

        public int countRangeSum(int[] nums, int lower, int upper) {
            root = new SegNodeForRangeSum();
            long l = 0, r = 0, s = 0;
            for (int i : nums) {
                s += i;
                l = Math.min(Math.min(l, s), Math.min(s - lower, s - upper));
                r = Math.max(Math.max(r, s), Math.max(s - lower, s - upper));
            }
            s = 0;
            int ans = 0;
            SegNodeForRangeSum.update(root, l, r, 0, 1);
            for (int i : nums) {
                s += i;
                long a = s - upper, b = s - lower;
                ans += SegNodeForRangeSum.query(root, l, r, a, b);
                SegNodeForRangeSum.update(root, l, r, s, 1);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution sln = new Solution();
        int[] nums = {-2, 5, -1};
        int lower = -2, upper = 2;
        System.out.println(sln.countRangeSum(nums, lower, upper));;
    }
}