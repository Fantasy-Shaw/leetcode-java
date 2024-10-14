package org.example.solutions.leetcode1kto2k;

public class Solution1954 {
    class Solution {
        public long minimumPerimeter(long neededApples) {
            long n = (long) Math.cbrt(neededApples / 4.0);
            if (2 * n * (n + 1) * (2 * n + 1) < neededApples) {
                n++;
            }
            return n * 8;
        }
    }

}