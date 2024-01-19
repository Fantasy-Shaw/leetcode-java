package org.example.solutions.leetcode2k;

public class Solution2806 {
    class Solution {
        public int accountBalanceAfterPurchase(int purchaseAmount) {
            int cost = (purchaseAmount / 10) * 10;
            cost += (purchaseAmount % 10 < 5) ? 0 : 10;
            return 100 - cost;
        }
    }
}