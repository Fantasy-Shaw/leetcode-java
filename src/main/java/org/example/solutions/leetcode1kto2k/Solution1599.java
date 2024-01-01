package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1599 {
    class Solution {
        public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
            int turn = 0, cnt = 0, cost = 0, mx = 0, ans = -1, wait = 0;
            do {
                wait += turn < customers.length ? customers[turn] : 0;
                if (wait >= 4) {
                    cnt += 4;
                    wait -= 4;
                } else {
                    cnt += wait;
                    wait = 0;
                }
                cost += runningCost;
                turn++;
                if (cnt * boardingCost - cost > mx) {
                    mx = cnt * boardingCost - cost;
                    ans = turn;
                }
            } while (wait != 0 || turn < customers.length);
            return ans;
        }
    }
}