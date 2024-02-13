package org.example.solutions.leetcode201to500;

import java.util.*;

public class Solution365 {
    class Solution {
        public boolean canMeasureWater(int c1, int c2, int target) {
            if (c1 + c2 < target) {
                return false;
            }
            if (c1 == 0 || c2 == 0) {
                return target == 0 || c1 + c2 == target;
            }
            return target % gcd(c1, c2) == 0;
        }

        private static int gcd(int x, int y) {
            if (y == 0) {
                return x;
            }
            return gcd(y, x % y);
        }
    }
}