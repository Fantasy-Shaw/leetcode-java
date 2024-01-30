package org.example.solutions.leetcode3k;

public class Solution3021 {
    class Solution { // [4,2]: 4 [4,4]: 8
        public long flowerGame(int n, int m) {
            if (n == 1 && m == 1) {
                return 0;
            }
            return (long) n * m / 2;
        }
    }
}