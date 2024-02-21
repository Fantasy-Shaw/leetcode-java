package org.example.solutions.leetcode201to500;

public class Solution371 {
    class Solution {
        public int getSum(int a, int b) {
            while (b != 0) {
                int carry = (a & b) << 1;
                a = a ^ b; // xor
                b = carry;
            }
            return a;
        }
    }
}