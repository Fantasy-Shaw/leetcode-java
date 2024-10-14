package org.example.solutions.leetcode501to1k;

public class Solution875 {
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            long l = 1, r = 1;
            for (int x : piles) {
                r += x;
            }
            while (l < r) {
                long mid = l + (r - l) / 2;
                if (!isValid(piles, mid, h)) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return (int) l;
        }

        private boolean isValid(int[] piles, long k, int h) {
            long t = 0;
            for (int x : piles) {
                t += x / k;
                if (x % k > 0) {
                    t++;
                }
            }
            return t <= h;
        }
    }
}