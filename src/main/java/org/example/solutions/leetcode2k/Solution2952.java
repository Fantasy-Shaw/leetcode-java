package org.example.solutions.leetcode2k;

import java.util.*;

public class Solution2952 {
    class Solution {
        /**
         * Leetcode-330
         */
        public int minimumAddedCoins(int[] coins, int target) {
            Arrays.sort(coins);
            int ans = 0;
            long s = 1;
            for (int i = 0; s <= target; ) {
                if (i < coins.length && coins[i] <= s) {
                    s += coins[i];
                    i++;
                } else {
                    s *= 2;
                    ans++;
                }
            }
            return ans;
        }
    }
}