package org.example.solutions.leetcode2k;

public class Solution2644 {
    class Solution {
        public int maxDivScore(int[] nums, int[] divisors) {
            int mxScore = -1, ans = Integer.MAX_VALUE;
            for (int x : divisors) {
                int score = 0;
                for (int y : nums) {
                    if (y != 0 && y % x == 0) {
                        score++;
                    }
                }
                if (score > mxScore || (score == mxScore && x < ans)) {
                    mxScore = score;
                    ans = x;
                }
            }
            return ans;
        }
    }
}