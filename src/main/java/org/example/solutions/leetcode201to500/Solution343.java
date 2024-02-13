package org.example.solutions.leetcode201to500;

import java.util.*;

public class Solution343 {
    class Solution {
        public int integerBreak(int n) {
            if (n <= 3) {
                return n - 1;
            }
            int q = n / 3, r = n % 3;
            if (r == 0) {
                return (int) Math.pow(3, q);
            } else if (r == 1) {
                return (int) Math.pow(3, q - 1) * 4;
            } else {
                return (int) Math.pow(3, q) * 2;
            }
        }
    }
}