package org.example.solutions.leetcode201to500;

public class Solution367 {
    class Solution {
        public boolean isPerfectSquare(int num) {
            long n = num;
            long l = 1, r = num;
            while (l <= r) {
                long mid = (l + r) >> 1;
                long cur = mid * mid;
                if (cur == n) return true;
                else if (cur > n) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return false;
        }
    }
}