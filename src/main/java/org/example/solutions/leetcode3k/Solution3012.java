package org.example.solutions.leetcode3k;

public class Solution3012 {
    class Solution {
        public int minimumArrayLength(int[] nums) {
            int mn = Integer.MAX_VALUE;
            for (int x : nums) {
                mn = Math.min(mn, x);
            }
            for (int x : nums) {
                if (x % mn > 0) {
                    return 1;
                }
            }
            int cnt = 0;
            for (int x : nums) {
                if (x == mn) {
                    cnt++;
                }
            }
            return (cnt + 1) / 2;
        }
    }
}