package org.example.solutions.leetcode3k;

public class Solution3100 {
    class Solution {
        public int maxBottlesDrunk(int numBottles, int numExchange) {
            int ans = 0;
            int numEmpty = 0;
            while (numBottles > 0) {
                ans += numBottles;
                numEmpty += numBottles;
                int num1 = 0;
                while (numEmpty >= numExchange) {
                    num1++;
                    numEmpty -= numExchange;
                    numExchange += 1;
                }
                numBottles = num1;
            }
            return ans;
        }
    }
}