package org.example.solutions.leetcode2k;

import java.util.*;

public class Solution2660 {
    class Solution {
        public int isWinner(int[] player1, int[] player2) {
            int s1 = getScores(player1), s2 = getScores(player2);
            if (s1 == s2) return 0;
            return s1 > s2 ? 1 : 2;
        }

        private int getScores(int[] player) {
            int prev1 = -1, prev2 = -1;
            int ans = 0;
            for (int j : player) {
                if (prev1 == 10 || prev2 == 10) {
                    ans += j * 2;
                } else {
                    ans += j;
                }
                prev1 = prev2;
                prev2 = j;
            }
            return ans;
        }
    }
}