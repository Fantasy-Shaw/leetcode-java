package org.example.solutions.leetcode2k;

public class Solution2560 {
    class Solution {
        public int minCapability(int[] nums, int k) {
            int l = 0, r = 0;
            for (int n : nums) {
                r = Math.max(r, n);
            }
            //BinarySearch - lowerBound
            r += 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (check(nums, k, mid)) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l;
        }

        private boolean check(int[] nums, int k, int capability) {
            int f = 0, g = 0;
            for (int x : nums) {
                if (x > capability) {
                    f = g;
                } else {
                    int t = g;
                    g = Math.max(g, f + 1);
                    f = t;
                }
            }
            return g < k;
        }
    }
}