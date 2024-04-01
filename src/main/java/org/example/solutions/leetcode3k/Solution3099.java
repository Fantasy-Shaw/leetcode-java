package org.example.solutions.leetcode3k;

public class Solution3099 {
    class Solution {
        public int sumOfTheDigitsOfHarshadNumber(int x) {
            char[] n = String.valueOf(x).toCharArray();
            int ans = 0;
            for (int i = 0; i < n.length; i++) {
                ans += n[i] - '0';
            }
            return x % ans == 0 ? ans : -1;
        }
    }
}