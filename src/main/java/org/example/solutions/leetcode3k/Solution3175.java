package org.example.solutions.leetcode3k;

public class Solution3175 {
    class Solution {
        public int findWinningPlayer(int[] skills, int k) {
            int[] wins = new int[skills.length];
            int mx = 0;
            for (int i = 1; i < skills.length; i++) {
                if (skills[i] > skills[mx]) {
                    mx = i;
                }
                if (++wins[mx] == k) {
                    return mx;
                }
            }
            return mx;
        }
    }
}