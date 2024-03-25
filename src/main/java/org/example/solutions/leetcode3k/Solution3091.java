package org.example.solutions.leetcode3k;

public class Solution3091 {
    /**
     * 2 -> 1
     */
    class Solution {
        public int minOperations(int k) {
            if (1 >= k) {
                return 0;
            }
            int ops = 0, x = 1;
            while (true) {
                ops++;
                x++;
                if (x * (1 + ops) >= k) {
                    break;
                }
            }
            return x * ops >= k ? 2 * ops - 1 : 2 * ops;
        }
    }
}