package org.example.solutions.leetcode201to500;

class Solution263 {
    private static final int[] factors = {2, 3, 5};

    public boolean isUgly(int n) {
        if (n <= 0) return false;
        for (int f : factors) {
            while (n % f == 0) {
                n /= f;
            }
        }
        return n == 1;
    }

    public static void main(String[] args) {
        
    }
}
